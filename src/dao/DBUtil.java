package dao;
import java.sql.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class DBUtil {

    //这里可以设置数据库名称
    private static final String URL="jdbc:sqlserver://czl233.database.windows.net:1433;" +
            "database=jwch;" +
            "user=czl;password=V9._pWQvt\\xU?c8F2;" +
            "encrypt=true;trustServerCertificate=false;" +
            "hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    private static final String USER="czl";
    private static final String PASSWORD="V9._pWQvt\\-xU?c8F2";

    private static Connection conn=null;

    //（将加载驱动、连接数据库放入静态块中），并对外提供一个方法来获取数据库连接
    public  Connection getConnection(){
        try {
            //1.加载驱动程序
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.获得数据库的连接
            conn=(Connection)DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void CloseConnection(){
    try{
        conn.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
      }


    //测试用例
    /**public static void main(String[] args) throws Exception{

        //3.通过数据库的连接操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        //ResultSet executeQuery(String sqlString)：执行查询数据库的SQL语句   ，返回一个结果集（ResultSet）对象。
        stmt.executeUpdate("insert into tb_users values (001,'123456',003)");
        ResultSet rs = stmt.executeQuery("select id,passwd,role_id from tb_users");
        while(rs.next()){//如果对象中有数据，就会循环打印出来
            System.out.println(rs.getInt("id")+","+rs.getString("passwd")+","+rs.getInt("role_id"));
        }
    }**/

}