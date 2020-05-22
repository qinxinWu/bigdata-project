package pku.qingxin.common.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库连接工具类
 * @author qingxin
 * @create 2020-05-07 16:33
 */
public class JDBCUtil {
    private static final String MYSQL_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String MYSQL_URL = "jdbc:mysql://192.168.60.101:3306/tel?useUnicode=true&characterEncoding=UTF-8";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "root";

    public static Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName(MYSQL_DRIVER_CLASS);
            connection = DriverManager.getConnection(MYSQL_URL,MYSQL_USERNAME,MYSQL_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
            return connection;
    }


  /*  public static void main(String[] args) {
        System.out.println(JDBCUtil.getConnection());
    }*/
}
