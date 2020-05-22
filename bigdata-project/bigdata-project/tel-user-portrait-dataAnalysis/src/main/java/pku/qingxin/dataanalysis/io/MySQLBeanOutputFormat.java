package pku.qingxin.dataanalysis.io;

import pku.qingxin.common.util.JDBCUtil;
import pku.qingxin.dataanalysis.kv.AnalysisKey;
import pku.qingxin.dataanalysis.kv.AnalysisValue;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * MySQL的数据格式化输出对象
 * @author qingxin
 * @create 2020-05-07 15:45
 */
public class MySQLBeanOutputFormat extends OutputFormat<AnalysisKey,AnalysisValue> {
    protected static class MySQLRecordWriter extends RecordWriter<AnalysisKey, AnalysisValue> {
        Connection connection = null;
        private Jedis jedis = null;

        /*private Map<String,Integer> userMap = new HashMap<String, Integer>();
        private Map<String,Integer> dateMap = new HashMap<String, Integer>();*/



        //获取资源
        public MySQLRecordWriter() {
            connection = JDBCUtil.getConnection();
            jedis = new Jedis("192.168.60.102",6379);

/*
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            //读取用户、时间数据
            String userSql = "select id,tel from contacts";
            String dateSql = "select id,year,month,day from date";
            try {
                preparedStatement = connection.prepareStatement(userSql);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    Integer id = resultSet.getInt(1);
                    String tel = resultSet.getString(2);
                    userMap.put(tel,id);
                }
                resultSet.close();
                preparedStatement = connection.prepareStatement(dateSql);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    Integer id = resultSet.getInt(1);
                    String year =resultSet.getString(2);
                    String month =resultSet.getString(3);
                    String day =resultSet.getString(4);

                    if (month == null){
                        month="";
                    }

                    if (day == null){
                        day ="";
                    }

                    if(month != "" &&month.length() == 1 ){
                        month = "0"+month;
                    }

                    if(day != "" &&day.length() == 1){
                        day = "0"+day;
                    }

                    dateMap.put(year+month+day,id);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(resultSet != null){
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if(preparedStatement != null){
                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            }*/


        }



        //输出数据
        public void write(AnalysisKey key, AnalysisValue value) throws IOException, InterruptedException {
           /* String[] splits = value.toString().split("-");
            String sumCall = splits[0];
            String sumDuration = splits[1];*/

            PreparedStatement preparedStatement = null;

            try {
                String insertSQL = "insert into tel_call(tel_id,date_id,sum_call,sum_duration) values(?,?,?,?)";
                preparedStatement = connection.prepareStatement(insertSQL);

             /*   String[] keys = key.toString().split("-");

                String tel = keys[0];
                String date = keys[1];*/

                //暂时写死
                preparedStatement.setInt(1,Integer.parseInt(jedis.hget("tel_user",key.getTel())));
                preparedStatement.setInt(2,Integer.parseInt(jedis.hget("tel_date",key.getDate())));
                preparedStatement.setInt(3,Integer.parseInt(value.getSumCall()));
                preparedStatement.setInt(4,Integer.parseInt(value.getSumDuration()));
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if(preparedStatement != null){
                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        //释放资源
        public void close(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(jedis != null){
                jedis.close();

            }

        }
    }






    public RecordWriter<AnalysisKey, AnalysisValue> getRecordWriter(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        return new MySQLRecordWriter();
    }

    public void checkOutputSpecs(JobContext jobContext) throws IOException, InterruptedException {

    }

    private FileOutputCommitter committer = null;
    public static Path getOutputPath(JobContext job) {
        String name = job.getConfiguration().get("mapreduce.output.fileoutputformat.outputdir");
        return name == null ? null : new Path(name);
    }
    public OutputCommitter getOutputCommitter(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        if (this.committer == null) {
            Path output = getOutputPath(taskAttemptContext);
            this.committer = new FileOutputCommitter(output, taskAttemptContext);
        }

        return this.committer;
    }
}
