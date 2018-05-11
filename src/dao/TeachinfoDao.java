package dao;
import model.Teachinfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class TeachinfoDao {
    Connection connTeach=DBUtil.getConnection();
    /************添加教师信息*************/
    public void addTeachinfo(Teachinfo t)throws SQLException{//通过PreparedStatement执行动态SQL语句
        String sql="insert into tb_teachinfo (id,name,birth,photo,tel,email,major) values(?,?,?,?,?,?,?)";
        PreparedStatement pstmt=connTeach.prepareStatement(sql);
        pstmt.setString(1,t.getId());
        pstmt.setString(2,t.getName());
        pstmt.setDate(3,t.getBirth());
        pstmt.setString(4,t.getPhoto());
        pstmt.setString(5,t.getTel());
        pstmt.setString(6,t.getEmail());
        pstmt.setInt(7,t.getMajor());

        pstmt.execute();
    }
    /************添加教师信息*************/
    //
    /************修改教师信息*************/
    public void updateTeachinfo(Teachinfo t)throws SQLException{
        String sql="update tb_users name=?,birth=?,photo=?,tel=?,email=?,major=? where id=?";
        PreparedStatement pstmt=connTeach.prepareStatement(sql);
        pstmt.setString(1,t.getName());
        pstmt.setDate(2,t.getBirth());
        pstmt.setString(3,t.getPhoto());
        pstmt.setString(4,t.getTel());
        pstmt.setString(5,t.getEmail());
        pstmt.setInt(6,t.getMajor());
        pstmt.setString(7,t.getId());
        pstmt.execute();
    }
    /************修改教师信息*************/
    //
    /************删除教师信息*************/
    public void deleteUsers(String id)throws SQLException{
        String sql="delete from tb_users where id=?";
        PreparedStatement pstmt=connTeach.prepareStatement(sql);
        pstmt.setString(1,id);
        pstmt.execute();
    }
    /************删除教师信息*************/
    //
    /************查询单个教师信息*************/
    public Teachinfo searchSingleTeachinfo(String id)throws SQLException{
        Teachinfo t=null;
        String sql="select * from tb_users where id=?";
        PreparedStatement pstmt=connTeach.prepareStatement(sql);
        pstmt.setString(1,id);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            t=new Teachinfo();
            t.setId(rs.getString("id"));
            t.setName(rs.getString("name"));
            t.setBirth(rs.getDate("birth"));
            t.setPhoto(rs.getString("photo"));
            t.setTel(rs.getString("tel"));
            t.setEmail(rs.getString("email"));
            t.setMajor(rs.getInt("major"));
        }
        return  t;
    }
    /************查询单个教师信息*************/

    /************查询所有教师信息*************/
    public List<Teachinfo>  searchAllTeachinfo()throws SQLException {
        String sql = "select * from tb_teachinfo";
        Statement stmt = connTeach.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Teachinfo> teachinfoList = new ArrayList<Teachinfo>();
        Teachinfo t = null;
        while (rs.next()) {
            t = new Teachinfo();
            t.setId(rs.getString("id"));
            t.setName(rs.getString("name"));
            t.setBirth(rs.getDate("birth"));
            t.setPhoto(rs.getString("photo"));
            t.setTel(rs.getString("tel"));
            t.setEmail(rs.getString("email"));
            t.setMajor(rs.getInt("major"));
            teachinfoList.add(t);
        }
        return teachinfoList;
    }
        /************查询所有教师信息*************/

}
