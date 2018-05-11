package dao;
import model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by Lxp
 *
 */
public class UsersDao {
    Connection connUser=DBUtil.getConnection();
    /************添加用户*************/
    public void addUsers(Users u)throws SQLException{//通过PreparedStatement执行动态SQL语句
        String sql="insert into tb_users (id,passwd,role_id) values(?,?,?)";
        PreparedStatement pstmt=connUser.prepareStatement(sql);
        pstmt.setString(1,u.getId());
        pstmt.setString(2,u.getPasswd());
        pstmt.setInt(3,u.getRole_id());
        pstmt.execute();
    }
    /************添加用户信息*************/
    //
    /************修改用户信息*************/
    public void updateUsers(Users u)throws SQLException{
        String sql="update tb_users set passwd=?,role_id=? where id=?";
        PreparedStatement pstmt=connUser.prepareStatement(sql);
        pstmt.setString(1,u.getPasswd());
        pstmt.setInt(2,u.getRole_id());
        pstmt.setString(3,u.getId());
        pstmt.execute();
    }
    /************修改用户信息*************/
    //
    /************删除用户信息*************/
    public void deleteUsers(String id)throws SQLException{
        String sql="delete from tb_users where id=?";
        PreparedStatement pstmt=connUser.prepareStatement(sql);
        pstmt.setString(1,id);
        pstmt.execute();
    }
    /************删除用户信息*************/
    //
    /************查询单个用户信息*************/
   public Users searchSingle(String id)throws SQLException{
       Users u=null;
       String sql="select * from tb_users where id=?";
       PreparedStatement pstmt=connUser.prepareStatement(sql);
       pstmt.setString(1,id);
       ResultSet rs=pstmt.executeQuery();
       while(rs.next()){
           u=new Users();
           u.setId(rs.getString("id"));
           u.setPasswd(rs.getString("passwd"));
           u.setRole_id(rs.getInt("role_id"));
       }
    return  u;
   }
    /************查询单个用户信息*************/

    /************查询所有用户信息*************/
   public List<Users>  search()throws SQLException{
       String sql="select * from tb_users";
       Statement stmt=connUser.createStatement();
       ResultSet rs=stmt.executeQuery(sql);
       List<Users> userList=new ArrayList<Users>();
       Users u=null;
       while(rs.next()){
        u=new Users();
        u.setId(rs.getString("id"));
        u.setPasswd(rs.getString("passwd"));
        u.setRole_id(rs.getInt("role_id"));
        userList.add(u);
       }
       return userList;
   }
    /************查询所有用户信息*************/

}
