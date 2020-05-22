package pku.qingxin.datacache;

import pku.qingxin.common.util.JDBCUtil;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * 启动缓存客户端.向redis中增加缓存数据
 * @author qingxin
 * @create 2020-05-08 9:33
 */
public class Bootstrap {
    public static void main(String[] args) {
        //读取mysql中的数据
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = JDBCUtil.getConnection();

      /*  Integer rowCount = 0;
        Integer mapCount = 0;*/


        Map<String,Integer> userMap = new HashMap<String, Integer>();
        Map<String,Integer> dateMap = new HashMap<String, Integer>();


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
                //rowCount++;
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
                //mapCount++;
            }
            //dateMap.put("201809",631);
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

            if(connection != null){

                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }

       /* System.out.println(userMap.size());
        System.out.println(dateMap.size());
        System.out.println(dateMap.get("201809"));*/
        //System.out.println(rowCount);
        //System.out.println(mapCount);
/*
        Set<Map.Entry<String, Integer>> entries = dateMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }*/
     /*   Collection<Integer> values = dateMap.values();
        Set<String> keySet = dateMap.keySet();

        List<Integer> integerList = new ArrayList<Integer>();
        for (Integer value : values) {
            integerList.add(value);
        }



        Collections.sort(integerList);
        System.out.println(integerList.size());
        System.out.println(keySet.size());

        for (Integer integer : integerList) {
            System.out.println(integer);
            
        }*/
      /*  boolean flag = false;
        for (Integer value : values) {
            for(int i = 1;i<=757;i++){
                if(value == i){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println(value);
            }
        }
*/

        //放入redis缓存服务器中
        Jedis jedisMaster = new Jedis("192.168.60.101",6379);
        Jedis jedisSlaveOne = new Jedis("192.168.60.102",6379);
        Jedis jedisSlaveTwo = new Jedis("192.168.60.103",6379);

        jedisSlaveOne.slaveof("192.168.60.101",6379);
        jedisSlaveTwo.slaveof("192.168.60.101",6379);

        Set<Map.Entry<String, Integer>> userEntries = userMap.entrySet();
        for (Map.Entry<String, Integer> userEntry : userEntries) {
            String userKey = userEntry.getKey();
            Integer userValue = userEntry.getValue();
            jedisMaster.hset("tel_user",userKey,""+userValue);
        }

        Set<Map.Entry<String, Integer>> dateEntries = dateMap.entrySet();
        for (Map.Entry<String, Integer> dateEntry : dateEntries) {
            String dateKey = dateEntry.getKey();
            Integer dateValue = dateEntry.getValue();
            jedisMaster.hset("tel_date",dateKey,""+dateValue);
        }


    /* jedisMaster.set("k1","v1");
     System.out.println(jedisSlaveOne.get("k1"));
*/


      /*  System.out.println(jedisM);
        System.out.println(jedisS);*/


    }
}
