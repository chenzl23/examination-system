package dao;
import model.Messages;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MessagesDao {
    Connection  connMsg=(new DBUtil()).getConnection();

    //addMessages
    public boolean addMessages(Messages msg)throws SQLException{
        String sql="insert into tb_messages (parent_id,from_id,to_id,time,message) values (?,?,?,?,?)";
        PreparedStatement pstmt=connMsg.prepareStatement(sql);
        pstmt.setInt(1,msg.getParent_id());
        pstmt.setString(2,msg.getFrom_id());
        pstmt.setString(3,msg.getTo_id());
        pstmt.setDate(4,msg.getTime());
        pstmt.setString(5,msg.getMessage());
        System.out.println(msg.getMessage());
        pstmt.execute();
        return true;
    }

    //updateMessages
    public boolean updateMessages(Messages msg)throws SQLException{/**一般用于添加子留言**/
        if(searchMessageById(msg.getMs_id())==null){return false;}
        else{
            String sql="update tb_messages set (from_id,to_id,time,message) where id=? or parent_id =?";
            PreparedStatement pstmt=connMsg.prepareStatement(sql);
            pstmt.setString(1,msg.getFrom_id());
            pstmt.setString(2,msg.getTo_id());
            pstmt.setDate(3,msg.getTime());
            pstmt.setString(4,msg.getMessage());
            pstmt.setInt(5,msg.getMs_id());
            pstmt.setInt(6,msg.getParent_id());
            pstmt.execute();
            return true;
        }
    }

    //deleteMessagesById
    public boolean deleteMessages(int ms_id)throws  SQLException{
        if(searchMessageById(ms_id)==null){
            return false;
        }
        else {
            String sql="delete from tb_messages where id=?";
            PreparedStatement pstmt=connMsg.prepareStatement(sql);
            pstmt.setInt(1,ms_id);
            pstmt.execute();
            return true;
        }
    }

    public List<Messages> searchMessage() throws SQLException{/**通过留言id查询**/
        Messages msg=null;
        List<Messages> mes = new ArrayList<>();
        String sql="select * from tb_messages";
        PreparedStatement pstmt=connMsg.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            msg=new Messages();
            msg.setMs_id(rs.getInt("id"));
            msg.setParent_id(rs.getInt("parent_id"));
            msg.setFrom_id(rs.getString("from_id"));
            msg.setTo_id(rs.getString("to_id"));
            msg.setTime(rs.getDate("time"));
            msg.setMessage(rs.getString("message"));
            mes.add(msg);
        }
        return mes;
    }

    //searchMessagesById
    public List<Messages> searchMessageById(int ms_id) throws SQLException{/**通过留言id查询**/
        Messages msg=null;
        List<Messages> mes = new ArrayList<>();
        String sql="select * from tb_messages where id=?";
        PreparedStatement pstmt=connMsg.prepareStatement(sql);
        pstmt.setInt(1,ms_id);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            msg=new Messages();
            msg.setMs_id(rs.getInt("id"));
            msg.setParent_id(rs.getInt("parent_id"));
            msg.setFrom_id(rs.getString("from_id"));
            msg.setTo_id(rs.getString("to_id"));
            msg.setTime(rs.getDate("time"));
            msg.setMessage(rs.getString("message"));
            mes.add(msg);
        }
        return mes;
    }

    //searchMessagesByF_id
    public List<Messages> searchMessagesByF_id(String from_id)throws SQLException{
        Messages msg=null;
        List<Messages> mes = new ArrayList<>();
        String sql="select * from tb_messages where from_id=?";
        PreparedStatement pstmt=connMsg.prepareStatement(sql);
        pstmt.setString(1,from_id);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            msg=new Messages();
            msg.setMs_id(rs.getInt("id"));
            msg.setParent_id(rs.getInt("parent_id"));
            msg.setFrom_id(rs.getString("from_id"));
            msg.setTo_id(rs.getString("to_id"));
            msg.setTime(rs.getDate("time"));
            msg.setMessage(rs.getString("message"));
            mes.add(msg);
        }
        return mes;

    }
    //searchMessagesByT_id
    public List<Messages> searchMessagesByT_id(String to_id)throws SQLException{
        Messages msg=null;
        String sql="select * from tb_messages where to_id=?";
        List<Messages> mes = new ArrayList<>();
        PreparedStatement pstmt=connMsg.prepareStatement(sql);
        pstmt.setString(1,to_id);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            msg=new Messages();
            msg.setMs_id(rs.getInt("id"));
            msg.setParent_id(rs.getInt("parent_id"));
            msg.setFrom_id(rs.getString("from_id"));
            msg.setTo_id(rs.getString("to_id"));
            msg.setTime(rs.getDate("time"));
            msg.setMessage(rs.getString("message"));
            mes.add(msg);
        }
        return mes;

    }

    //searchMessagesByTime
    public Messages searchMessagesByTime(Date time)throws SQLException{/**通过留言时间查询留言信息**/
        Messages msg=null;
        String sql="select * from tb_messages where time=?";
        PreparedStatement pstmt=connMsg.prepareStatement(sql);
        pstmt.setDate(1,time);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            msg=new Messages();
            msg.setMs_id(rs.getInt("id"));
            msg.setParent_id(rs.getInt("parent_id"));
            msg.setFrom_id(rs.getString("from_id"));
            msg.setTo_id(rs.getString("to_id"));
            msg.setTime(rs.getDate("time"));
            msg.setMessage(rs.getString("messages"));
        }
        return msg;
    }
}
