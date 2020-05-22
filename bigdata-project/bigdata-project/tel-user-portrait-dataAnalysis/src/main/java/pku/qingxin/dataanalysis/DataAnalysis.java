package pku.qingxin.dataanalysis;

import pku.qingxin.dataanalysis.tool.AnalysisCallPathTextTool;
import org.apache.hadoop.util.ToolRunner;

/**
 * 统计分析数据
 * @author qingxin
 * @create 2020-05-07 15:15
 */
public class DataAnalysis {
    public static void main(String[] args) throws Exception{
        //int result = ToolRunner.run(new AnalysisTextTool(),args);
        //int result = ToolRunner.run(new AnalysisBeanTool(),args);
        //int result = ToolRunner.run(new AnalysisIntimacyTextTool(),args);
        int result = ToolRunner.run(new AnalysisCallPathTextTool(),args);


    }




}
