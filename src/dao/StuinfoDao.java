package dao;
import model.Stuinfo;
import service.MajorService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

/**
 * @author by Lxp
 * @// TODO: 2018/5/8 17:36
 */
public class StuinfoDao {
    Connection connStu=(new DBUtil()).getConnection();
    /************添加学生*************/
    public boolean addStuinfo(Stuinfo s)throws SQLException{//通过PreparedStatement执行动态SQL语句
        if(searchSingleStuinfo(s.getId())!=null) return false;
        else {
            String sql = "insert into tb_stuinfo (id,name,birth,photo,tel,email,major,enroll_year,credit_got,credit_need) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = connStu.prepareStatement(sql);
            pstmt.setString(1, s.getId());
            pstmt.setString(2, s.getName());
            pstmt.setDate(3, s.getBirth());
            pstmt.setString(4, s.getPhoto());
            pstmt.setString(5, s.getTel());
            pstmt.setString(6, s.getEmail());
            /**@// TODO: 2018/5/10 通过专业名称映射专业id**/
            MajorService mjs = new MajorService();
            pstmt.setInt(7, mjs.searchMajorIdService(s.getMajor()).getM_id());
            /**通过专业名称映射专业id **/
            pstmt.setInt(8, s.getEnrollyear());
            pstmt.setDouble(9, s.getCredit_got());
            pstmt.setDouble(10, s.getCredit_need());
            pstmt.execute();
            return true;
        }
    }
    /************添加学生信息*************/
    //
    /************修改学生信息*************/
    public boolean updateStuinfo(Stuinfo s)throws SQLException{
        if(searchSingleStuinfo(s.getId())==null) return false;
        else {
            String sql = "update tb_stuinfo set name=?,birth=?,photo=?,tel=?,email=?,major=?,enrollyear=?,credit_got=?,credit_need=? where id=?";
            PreparedStatement pstmt = connStu.prepareStatement(sql);
            pstmt.setString(1, s.getName());
            pstmt.setDate(2, s.getBirth());
            pstmt.setString(3, s.getPhoto());
            pstmt.setString(4, s.getTel());
            pstmt.setString(5, s.getEmail());
            /**@// TODO: 2018/5/10 通过专业名称映射专业id **/
            MajorService mjs = new MajorService();
            pstmt.setInt(6, mjs.searchMajorIdService(s.getMajor()).getM_id());
            /**通过专业名称映射专业id **/
            pstmt.setInt(7, s.getEnrollyear());
            pstmt.setDouble(8, s.getCredit_got());
            pstmt.setDouble(9, s.getCredit_need());
            pstmt.setString(10, s.getId());
            pstmt.execute();
        return true;
        }
    }
    /************修改学生信息*************/
    //
    /************删除学生信息*************/
    public boolean deleteStuinfo(String id)throws SQLException{
        if(searchSingleStuinfo(id)!=null) return false;
        else {
            String sql = "delete from tb_stuinfo where id=?";/**@// TODO: 2018/5/12 修改bug tb_users->tb_stuinfo **/
            PreparedStatement pstmt = connStu.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.execute();
        return true;
        }
    }
    /************删除学生信息*************/
    //
    /************查询单个学生信息*************/
    public Stuinfo searchSingleStuinfo(String id)throws SQLException{
        Stuinfo s=null;
        String sql="select * from tb_stuinfo where id=?";
        PreparedStatement pstmt=connStu.prepareStatement(sql);
        pstmt.setString(1,id);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            s=new Stuinfo();
            s.setId(rs.getString("id"));
            s.setName(rs.getString("name"));
            s.setBirth(rs.getDate("birth"));
            s.setPhoto(rs.getString("photo"));
            s.setTel(rs.getString("tel"));
            s.setEmail(rs.getString("email"));
            /**@// TODO: 2018/5/10 通过专业id映射专业名称 **/
            MajorService mjs=new MajorService();
            s.setMajor(mjs.searchMajorNameService(rs.getInt("major")).getM_name());
           /** 通过专业id映射专业名称**/
            s.setEnrollyear(rs.getInt("enroll_year"));
            s.setCredit_got(rs.getDouble("credit_got"));
            s.setCredit_need(rs.getDouble("credit_need"));
        }
        return  s;
    }
    /************查询单个学生信息*************/

    /************查询所有学生信息*************/
    public List<Stuinfo>  searchAllStuinfo()throws SQLException{
        String sql="select * from tb_stuinfo";
        Statement stmt=connStu.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        List<Stuinfo> stuinfoList=new ArrayList<Stuinfo>();
        Stuinfo s=null;
        while(rs.next()){
            s=new Stuinfo();
            s.setId(rs.getString("id"));
            s.setName(rs.getString("name"));
            s.setBirth(rs.getDate("birth"));
            s.setPhoto(rs.getString("photo"));
            s.setTel(rs.getString("tel"));
            s.setEmail(rs.getString("email"));
            /**@// TODO: 2018/5/10 通过专业id映射专业名称 **/
            MajorService mjs=new MajorService();
            s.setMajor(mjs.searchMajorNameService(rs.getInt("major")).getM_name());
            /** 通过专业id映射专业名称**/
            s.setEnrollyear(rs.getInt("enroll_year"));
            s.setCredit_got(rs.getDouble("credit_got"));
            s.setCredit_need(rs.getDouble("credit_need"));
            stuinfoList.add(s);
        }
        return stuinfoList;
    }
    /************查询所有学生信息*************/
}
