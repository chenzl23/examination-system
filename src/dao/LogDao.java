package dao;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import model.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LogDao {
    Connection connlog=new DBUtil().getConnection();

    /**添加新的登录记录**/
    public boolean addLog(Log lg)throws SQLException{
        if(searchSingleLog(lg.getLogin_id())!=null)return false;
        else{
            String sql="insert into tb_log (id,login_time,key_value) values (?,?,?)";
            PreparedStatement pstmt=connlog.prepareStatement(sql);
            pstmt.setInt(1,lg.getLogin_id());
            pstmt.setDate(2,lg.getLogin_time());
            pstmt.setString(3,lg.getKey());
            pstmt.execute();
            return true;
        }
    }
    /**添加新的登录记录**/

    /**更新已有登录记录**/
    public boolean updateLog(Log lg)throws SQLException{
        if (searchSingleLog(lg.getLogin_id())==null)return false;
        else {
            String sql = "update tb_log set login_time=?,key_value=? where id=?";
            PreparedStatement pstmt
                    = connlog.prepareStatement(sql);
            pstmt.setDate(1, lg.getLogin_time());
            pstmt.setString(2, lg.getKey());
            pstmt.setInt(3, lg.getLogin_id());
            pstmt.execute();
            return true;
        }
    }
    /**更新已有登录记录**/

    /**删除已有登录记录**/
    public boolean deleteLog(int login_id)throws SQLException{
        if(searchSingleLog(login_id)==null) return false;
        else {
            String sql = "delete from tb_log where id=?";
            PreparedStatement pstmt = connlog.prepareStatement(sql);
            pstmt.setInt(1, login_id);
            pstmt.execute();
        return true;
        }
    }
    /**删除已有登录记录**/

    /**查询单个登录记录**/
    public Log searchSingleLog(int login_id)throws SQLException{
        Log lg=null;
        String sql="select * from tb_log where id=?";
        PreparedStatement pstmt=connlog.prepareStatement(sql);
        pstmt.setInt(1,login_id);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            lg=new Log();
            lg.setLogin_id(rs.getInt("id"));
            lg.setLogin_time(rs.getDate("login_time"));
            lg.setKey(rs.getString("key_value"));
        }
        return lg;
    }
/**查询单个登录记录**/

/**查询所有登录记录**/
    public List<Log> searchAllLog()throws SQLException{
        String sql="select * from tb_log";
        Statement stmt=connlog.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        List<Log> logList=new ArrayList<Log>();
        Log lg=null;
        while (rs.next()){
            lg=new Log();
            lg.setLogin_id(rs.getInt("id"));
            lg.setLogin_time(rs.getDate("login_time"));
            lg.setKey(rs.getString("key_value"));
            logList.add(lg);
        }
        return logList;
    }
/**查询所有登录记录**/

}
