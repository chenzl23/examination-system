package dao;
import model.Teachinfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class TeachinfoDao {
    Connection connTeach=(new DBUtil()).getConnection();
    /************添加教师信息*************/
    public boolean addTeachinfo(Teachinfo t)throws SQLException{//通过PreparedStatement执行动态SQL语句
        if(searchSingleTeachinfo(t.getT_id())!=null) return false;
        else {
            String sql = "insert into tb_teachinfo (id,name,birth,photo,tel,email,major) values(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = connTeach.prepareStatement(sql);
            pstmt.setString(1, t.getT_id());
            pstmt.setString(2, t.getT_name());
            pstmt.setDate(3, t.getT_birth());
            pstmt.setString(4, t.getT_photo());
            pstmt.setString(5, t.getT_tel());
            pstmt.setString(6, t.getT_email());
            pstmt.setInt(7, t.getT_major());
            pstmt.execute();
        return true;
        }
    }
    /************添加教师信息*************/
    //
    /************修改教师信息*************/
    public boolean updateTeachinfo(Teachinfo t)throws SQLException{
        if(searchSingleTeachinfo(t.getT_id())==null) return false;
        else {
            String sql = "update tb_teachinfo name=?,birth=?,photo=?,tel=?,email=?,major=? where id=?";
            PreparedStatement pstmt = connTeach.prepareStatement(sql);
            pstmt.setString(1, t.getT_name());
            pstmt.setDate(2, t.getT_birth());
            pstmt.setString(3, t.getT_photo());
            pstmt.setString(4, t.getT_tel());
            pstmt.setString(5, t.getT_email());
            pstmt.setInt(6, t.getT_major());
            pstmt.setString(7, t.getT_id());
            pstmt.execute();
        return true;
        }
    }
    /************修改教师信息*************/
    //
    /************删除教师信息*************/
    public boolean deleteTeachinfo(String t_id)throws SQLException{
        if(searchSingleTeachinfo(t_id)==null) return false;
        else {
            String sql = "delete from tb_teachinfo where id=?";/**@// TODO: 2018/5/12 修改bug tb_users->tb_teachinfo **/
            PreparedStatement pstmt = connTeach.prepareStatement(sql);
            pstmt.setString(1, t_id);
            pstmt.execute();
            return true;
        }
    }
    /************删除教师信息*************/
    //
    /************查询单个教师信息*************/
    public Teachinfo searchSingleTeachinfo(String t_id)throws SQLException{
        Teachinfo t=null;
        String sql="select * from tb_teachinfo where id=?";/**@// TODO: 2018/5/12 修改bug tb_users->tb_teachinfo **/
        PreparedStatement pstmt=connTeach.prepareStatement(sql);
        pstmt.setString(1,t_id);
        ResultSet rs=pstmt.executeQuery();
        t = duplicatedCode(t, rs);
        return  t;
    }
    /************查询单个教师信息*************/

    /************查询所有教师信息*************/
    public List<Teachinfo>  searchAllTeachinfo()throws SQLException {
        String sql = "select * from tb_teachinfo";/**@// TODO: 2018/5/12 修改bug tb_users->tb_teachinfo **/
        Statement stmt = connTeach.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Teachinfo> teachinfoList = new ArrayList<Teachinfo>();
        Teachinfo t = null;
        while (rs.next()) {
            t = new Teachinfo();
            t.setT_id(rs.getString("id"));
            t.setT_name(rs.getString("name"));
            t.setT_birth(rs.getDate("birth"));
            t.setT_photo(rs.getString("photo"));
            t.setT_tel(rs.getString("tel"));
            t.setT_email(rs.getString("email"));
            t.setT_major(rs.getInt("major"));
            teachinfoList.add(t);
        }
        return teachinfoList;
    }
        /************查询所有教师信息*************/

        /************通过教师姓名查询教师信息*****/
        public Teachinfo searchTeachinfoByName(String t_name)throws SQLException{
            Teachinfo t=null;
            String sql="select * from tb_teachinfo where name=?";/**@// TODO: 2018/5/12 修改bug tb_users->tb_teachinfo **/
            PreparedStatement pstmt=connTeach.prepareStatement(sql);
            pstmt.setString(1,t_name);
            ResultSet rs=pstmt.executeQuery();
            t = duplicatedCode(t, rs);
            return  t;
        }

        //查询所需的重用代码
    private Teachinfo duplicatedCode(Teachinfo t, ResultSet rs) throws SQLException {
        while(rs.next()){
            t=new Teachinfo();
            t.setT_id(rs.getString("id"));
            t.setT_name(rs.getString("name"));
            t.setT_birth(rs.getDate("birth"));
            t.setT_photo(rs.getString("photo"));
            t.setT_tel(rs.getString("tel"));
            t.setT_email(rs.getString("email"));
            t.setT_major(rs.getInt("major"));
        }
        return t;
    }
}
