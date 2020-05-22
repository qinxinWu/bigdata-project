package pku.qingxin.dataanalysis.mapper;

import pku.qingxin.dataanalysis.kv.AnalysisKey;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.Text;

import java.io.IOException;

/**
 * 统计分析数据的mapper
 * @author qingxin
 * @create 2020-05-07 15:34
 */
public class AnalysisBeanMapper extends TableMapper<AnalysisKey,Text>{
    @Override
    protected void map(ImmutableBytesWritable key, Result value, Context context) throws IOException, InterruptedException {
        //super.map(key, value, context);
        //5-19609872345-20180802160723-18998765432-0089-1
        String rowkey = Bytes.toString(key.get());
        String[] splits = rowkey.split("-");

        String call1 = splits[1];
        String call2 = splits[3];
        String calltime = splits[2];
        String duration = splits[4];

        String year = calltime.substring(0,4);
        String month = calltime.substring(0,6);
        String day = calltime.substring(0,8);

        //呼叫者用户-年
        context.write(new AnalysisKey(call1 , year),new Text(duration));
        //呼叫者用户-月
        context.write(new AnalysisKey(call1 , month),new Text(duration));
        //呼叫者用户-日
        context.write(new AnalysisKey(call1 , day),new Text(duration));

        //被呼叫者用户-年
        context.write(new AnalysisKey(call2 , year),new Text(duration));
        //被呼叫者用户-月
        context.write(new AnalysisKey(call2 , month),new Text(duration));
        //被呼叫者用户-日
        context.write(new AnalysisKey(call2 , day),new Text(duration));
    }
}
