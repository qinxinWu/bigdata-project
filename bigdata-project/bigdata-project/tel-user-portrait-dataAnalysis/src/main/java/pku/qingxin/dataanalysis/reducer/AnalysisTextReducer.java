package pku.qingxin.dataanalysis.reducer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * 统计分析数据的reducer
 * @author qingxin
 * @create 2020-05-07 15:39
 */
public class AnalysisTextReducer extends Reducer<Text,Text,Text,Text>{
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //super.reduce(key, values, context);
        int sumCall = 0;
        int sumDuration = 0;

        for (Text value : values) {
            int duration = Integer.parseInt(value.toString());
            sumDuration+=duration;
            sumCall++;
        }

        context.write(key,new Text(sumCall + "-" +sumDuration));
    }
}
