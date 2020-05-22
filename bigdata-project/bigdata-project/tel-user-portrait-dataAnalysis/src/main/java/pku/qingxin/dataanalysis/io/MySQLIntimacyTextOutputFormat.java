package pku.qingxin.dataanalysis.io;

import pku.qingxin.common.util.JDBCUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
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
public class MySQLIntimacyTextOutputFormat extends OutputFormat<Text,Text> {
    protected static class MySQLRecordWriter extends RecordWriter<Text, Text> {
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
        public void write(Text key, Text value) throws IOException, InterruptedException {
            String[] splits = value.toString().split("-");
            String sumCall = splits[0];
            String sumDuration = splits[1];
            PreparedStatement preparedStatement = null;

            try {
                String insertSQL = "insert into intimacy(rank,tel_id1,tel_id2,date_id,sum_call,sum_duration) values(?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(insertSQL);

                String[] keys = key.toString().split("-");

                String tel1 = keys[0];
                String tel2 = keys[1];
                String date = keys[2];

                //暂时写死
                preparedStatement.setInt(1,1);
                preparedStatement.setInt(2,Integer.parseInt(jedis.hget("tel_user",tel1)));
                preparedStatement.setInt(3,Integer.parseInt(jedis.hget("tel_user",tel2)));
                preparedStatement.setInt(4,Integer.parseInt(jedis.hget("tel_date",date)));
                preparedStatement.setInt(5,Integer.parseInt(sumCall));
                preparedStatement.setInt(6,Integer.parseInt(sumDuration));
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






    public RecordWriter<Text, Text> getRecordWriter(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
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
