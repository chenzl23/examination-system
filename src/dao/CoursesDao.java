package dao;
import model.Courses;

import javax.swing.plaf.ColorUIResource;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
public class CoursesDao {
    Connection connCourse=(new DBUtil()).getConnection();
    /*****添加课程信息******/
    public boolean addCourse(Courses cs)throws SQLException{/**返回boolean值确认是否允许添加(如添加的课程是否已经在课程
         信息表中，存在则不允许添加)**/
        if(searchSingleCourse(cs.getC_id())!=null)return false;
        else {
            String sql = "insert into tb_courses (id,c_name,grade,credit) values(?,?,?,?)";
            PreparedStatement pstmt = connCourse.prepareStatement(sql);
            pstmt.setInt(1, cs.getC_id());
            pstmt.setString(2, cs.getC_name());
            pstmt.setInt(3, cs.getGrade());
            pstmt.setDouble(4, cs.getCredit());
            pstmt.execute();
            return true;
        }
    }
    /*****添加课程信息******/

    /*****更新某个课程的信息******/
    public boolean updateCourse(Courses cs)throws SQLException{/**返回boolean值判断课程信息表是否存在要更新的课程，
         存在则更新，否则返回false**/
        if(searchSingleCourse(cs.getC_id())==null)return false;
        else
        {
            String sql="update tb_courses set c_name=?,grade=?,credit=? where id=?";
            PreparedStatement pstmt=connCourse.prepareStatement(sql);
            pstmt.setString(1,cs.getC_name());
            pstmt.setInt(2,cs.getGrade());
            pstmt.setDouble(3,cs.getCredit());
            pstmt.setInt(4,cs.getC_id());
            pstmt.execute();
            return true;
        }
    }
    /*****更新某个课程的信息******/

    /*****删除某个课程的信息******/
    public boolean delteCourse(int id)throws SQLException{/**返回boolean确认删除是否成功**/
        if(searchSingleCourse(id)==null)return false;
        else{
            String sql="delete from tb_courses where id=?";
            PreparedStatement pstmt=connCourse.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.execute();
            return true;
        }
    }
    /*****删除某个课程的信息******/

    /*****查询某个课程的信息******/
    public Courses searchSingleCourse(int id)throws SQLException{
        Courses cs=null;
        String sql="select * from tb_courses where id=?";
        PreparedStatement pstmt=connCourse.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs=pstmt.executeQuery();
        cs = getCourses(cs, rs);
        return cs;
    }

    //查询所需重用代码
    private Courses getCourses(Courses cs, ResultSet rs) throws SQLException {
        while (rs.next()){
            cs=new Courses();
            cs.setC_id(rs.getInt("id"));
            cs.setC_name(rs.getString("c_name"));
            cs.setGrade(rs.getInt("grade"));
            cs.setCredit(rs.getDouble("credit"));
        }
        return cs;
    }

    /*****查询某个课程的信息******/

    /*****通过课程名称c_name查询某个课程的信息******/
    public Courses searchCourseByName(String name)throws SQLException{
        Courses cs=null;
        String sql="select * from tb_courses where c_name=?";
        PreparedStatement pstmt=connCourse.prepareStatement(sql);
        pstmt.setString(1,name);
        ResultSet rs=pstmt.executeQuery();
        cs = getCourses(cs, rs);
        return cs;
    }

    /*****通过课程名称c_name查询某个课程的信息******/

    /*****查询所有课程的信息******/
    public List<Courses> searchAllCourse()throws SQLException{
        String sql="select * from tb_courses ";
        Statement stmt=connCourse.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        List<Courses> coursesList=new ArrayList<Courses>();
        duplicatedCode(rs, coursesList);
        return coursesList;
    }
    /*****查询所有课程的信息******/
/**
 * @// TODO: 2018/5/9 22:53 添加了通过教师id查询其负责的课程信息功能
 */
    /**
     * @// TODO: 2018/5/11 21：43 由于将teacher属性改到选课表，删除了通过教师id查询其负责的课程信息功能
     *
     */

    //查询需要的重用代码
    private void duplicatedCode(ResultSet rs, List<Courses> coursesList1) throws SQLException {
        Courses cst=null;
        while(rs.next()){
            cst=new Courses();
            cst.setC_id(rs.getInt("id"));
            cst.setC_name(rs.getString("c_name"));
            cst.setGrade(rs.getInt("grade"));
            cst.setCredit(rs.getDouble("credit"));
            coursesList1.add(cst);
        }
    }
}
