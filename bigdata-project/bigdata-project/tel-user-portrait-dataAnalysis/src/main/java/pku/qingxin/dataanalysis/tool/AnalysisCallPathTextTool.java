package pku.qingxin.dataanalysis.tool;

import pku.qingxin.common.constant.Names;
import pku.qingxin.dataanalysis.io.MySQLCallPathTextOutputFormat;
import pku.qingxin.dataanalysis.mapper.AnalysisCallPathTextMapper;
import pku.qingxin.dataanalysis.reducer.AnalysisCallPathTextReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.JobStatus;
import org.apache.hadoop.util.Tool;

/**
 * 统计分析数据的工具类
 * @author qingxin
 * @create 2020-05-07 15:17
 */
public class AnalysisCallPathTextTool implements Tool{
    public int run(String[] strings) throws Exception {
        Job job = Job.getInstance();
        job.setJarByClass(AnalysisCallPathTextTool.class);

        Scan scan = new Scan();
        scan.addFamily(Bytes.toBytes(Names.CF_CALLER.getValue()));

        //mapper
        TableMapReduceUtil.initTableMapperJob(
                Names.TABLE.getValue(),
                scan,
                AnalysisCallPathTextMapper.class,
                Text.class,
                Text.class,
                job
        );

        //reducer
        job.setReducerClass(AnalysisCallPathTextReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        //outputformat
        job.setOutputFormatClass(MySQLCallPathTextOutputFormat.class);




        boolean flag = job.waitForCompletion(true);
        if(flag){
            return JobStatus.State.SUCCEEDED.getValue();
        }else{
            return JobStatus.State.FAILED.getValue();
        }

    }

    public void setConf(Configuration configuration) {

    }

    public Configuration getConf() {
        return null;
    }
}
