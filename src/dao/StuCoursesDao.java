package dao;
import model.Courses;
import model.StuCourses;
import service.CoursesService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by Lxp
 * @// TODO: 2018/5/10
 */
public class StuCoursesDao {
    Connection connStucs=(new DBUtil()).getConnection();

    /**添加新的选课**/
    public boolean addStuCourse(StuCourses stuCourses)throws SQLException{/**设置boolean返回值判断是否允许添加新的选课**/
        if(searchStuCourse(stuCourses.getSc_id())!=null){System.out.println(searchStuCourse(stuCourses.getSc_id())+"ewr");return false;}
        else{
            String sql="insert into tb_stu_courses " +
                    "(id,cno,sno,teacher,term,daily_work,mid_exam,final_exam,total_remark,status,experiment)" +
                    " values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt=connStucs.prepareStatement(sql);
            pstmt.setInt(1,stuCourses.getSc_id());
            pstmt.setInt(2,stuCourses.getCno());
            pstmt.setString(3,stuCourses.getSno());
            pstmt.setString(4,stuCourses.getTeacher());
            pstmt.setInt(5,stuCourses.getTerm());
            pstmt.setDouble(6,stuCourses.getDaily_work());
            pstmt.setDouble(7,stuCourses.getMid_exam());
            pstmt.setDouble(8,stuCourses.getFinal_exam());
            pstmt.setDouble(9,stuCourses.getTotal_remark());
            pstmt.setInt(10,stuCourses.getStatus());
            pstmt.setDouble(11,stuCourses.getExperiment());
            pstmt.execute();
            return true;
        }
    }
    /**添加新的选课**/

    /**仅仅根据选课sc_id更新选课**/
    public boolean updateStuCourse(StuCourses stuCourses)throws SQLException{
        if(searchStuCourse(stuCourses.getSc_id())==null)return false;
        else{
            String sql="update tb_stu_courses set cno=?,sno=?,teacher=?,term=?,daily_work=?,mid_exam=?,final_exam=?,total_remark=?,status=?,experiment=? " +
                    "where id=?";
            PreparedStatement pstmt=connStucs.prepareStatement(sql);
            pstmt.setInt(1,stuCourses.getCno());
            pstmt.setString(2,stuCourses.getSno());
            pstmt.setString(3,stuCourses.getTeacher());
            pstmt.setInt(4,stuCourses.getTerm());
            pstmt.setDouble(5,stuCourses.getDaily_work());
            pstmt.setDouble(6,stuCourses.getMid_exam());
            pstmt.setDouble(7,stuCourses.getFinal_exam());
            pstmt.setDouble(8,stuCourses.getTotal_remark());
            pstmt.setDouble(10,stuCourses.getExperiment());
            pstmt.setInt(11,stuCourses.getSc_id());
            //超过60分状态改为课程通过，否则未通过
            if (stuCourses.getTotal_remark() >=60)
            {
                pstmt.setInt(9,3);
            }
            else
            {
                pstmt.setInt(9,4);
            }
            pstmt.execute();
            return true;
        }
    }
    /**仅仅根据选课sc_id更新选课**/

    /**仅仅根据选课sc_id删除选课**/
    public boolean deleteStuCourse(int sc_id)throws SQLException{
        if(searchStuCourse(sc_id)==null)return false;
        else{
        String sql="delete from tb_stu_courses where id=?";
        PreparedStatement pstmt=connStucs.prepareStatement(sql);
        pstmt.execute();
        return true;
        }
    }
    /**仅仅根据选课sc_id删除选课**/

    /**通过选课sc_id查找选课信息**/
    public StuCourses searchStuCourse(int sc_id)throws SQLException{
        StuCourses stuCourses=null;
        String sql="select * from tb_stu_courses where id=?";
        PreparedStatement pstmt=connStucs.prepareStatement(sql);
        pstmt.setInt(1,sc_id);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            stuCourses=new StuCourses();
            stuCourses.setSc_id(rs.getInt("id"));
            stuCourses.setCno(rs.getInt("cno"));
            stuCourses.setSno(rs.getString("sno"));
            stuCourses.setTeacher(rs.getString("teacher"));
            stuCourses.setTerm(rs.getInt("term"));
            stuCourses.setDaily_work(rs.getDouble("daily_work"));
            stuCourses.setMid_exam(rs.getDouble("mid_exam"));
            stuCourses.setFinal_exam(rs.getDouble("final_exam"));
            stuCourses.setExperiment(rs.getDouble("experiment"));
            /**通过对实验成绩experiment的判断来设置返回的总评成绩和is_experiment**/
            stuCourses.setTotal_remark(rs.getDouble("total_remark"));
            stuCourses.setStatus(rs.getInt("status"));

        }
        return stuCourses;
    }
    /**通过选课sc_id查找选课信息**/

    /**通过 学号+学期+课程名字查询选课信息（主要是学生查询成绩）**/
    public List<StuCourses> searchStuScore(String sno)throws SQLException{
        CoursesService css=new CoursesService();
        StuCourses stuCourses=null;
        String sql="select * from tb_stu_courses where sno=?";
        PreparedStatement pstmt=connStucs.prepareStatement(sql);
        pstmt.setString(1,sno);
        ResultSet rs=pstmt.executeQuery();
        List<StuCourses> scoreList=new ArrayList<StuCourses>();
        while(rs.next()){
            stuCourses=new StuCourses();
            stuCourses.setCno(rs.getInt("cno"));
            stuCourses.setSc_id(rs.getInt("id"));
            stuCourses.setSno(rs.getString("sno"));
            stuCourses.setTeacher(rs.getString("teacher"));
            stuCourses.setTerm(rs.getInt("term"));
            stuCourses.setDaily_work(rs.getDouble("daily_work"));
            stuCourses.setMid_exam(rs.getDouble("mid_exam"));
            stuCourses.setFinal_exam(rs.getDouble("final_exam"));
            stuCourses.setExperiment(rs.getDouble("experiment"));
            /**通过对实验成绩experiment的判断来设置返回的总评成绩和is_experiment**/
            stuCourses.setTotal_remark(rs.getDouble("total_remark"));
            stuCourses.setStatus(rs.getInt("status"));
            scoreList.add(stuCourses);
        }
    return scoreList;
}
    /**通过 学号+学期+课程名字查询选课信息,（主要用于学生查询成绩）**/

    /**通过 学期+教师+课程名字,（主要用于教师/管理员查询成绩）**/
    public List<StuCourses> getScoreByTeacher(int term,String teacher,int cno)throws SQLException{
        String sql;
        PreparedStatement pstmt;
        if (teacher == null)
        {
            sql="select * from tb_stu_courses where term=? and cno=?";
            pstmt=connStucs.prepareStatement(sql);
            pstmt.setInt(1,term);
            pstmt.setInt(2,cno);
        }
        else {
            sql="select * from tb_stu_courses where term=? and teacher=? and cno=?";
            pstmt=connStucs.prepareStatement(sql);
            pstmt.setInt(1,term);
            pstmt.setString(2,teacher);
            pstmt.setInt(3,cno);
        }
        ResultSet rs=pstmt.executeQuery();
        List<StuCourses> scoreList=new ArrayList<StuCourses>();
        StuCourses stuCourses=null;
        while(rs.next()){
          stuCourses=new StuCourses();
          stuCourses.setSc_id(rs.getInt("id"));
          stuCourses.setCno(rs.getInt("cno"));
          stuCourses.setSno(rs.getString("sno"));
          stuCourses.setDaily_work(rs.getDouble("daily_work"));
          stuCourses.setTeacher(rs.getString("teacher"));
          stuCourses.setTerm(rs.getInt("term"));
          stuCourses.setMid_exam(rs.getInt("mid_exam"));
          stuCourses.setFinal_exam(rs.getDouble("final_exam"));
          stuCourses.setExperiment(rs.getDouble("experiment"));
            /**通过对实验成绩experiment的判断来设置返回的总评成绩和is_experiment**/
            stuCourses.setTotal_remark(rs.getDouble("total_remark"));
            stuCourses.setStatus(rs.getInt("status"));
            scoreList.add(stuCourses);
        }
        return scoreList;
    }
    /**通过学期+教师+课程名字,（主要用于教师/管理员查询成绩）**/

    /**通过教师+学期查询教师当前学期负责的所有课程**/
    public List<Integer> getCoursesOf(int term,String teacher)throws SQLException{
        String sql="select cno from tb_stu_courses where term=? and teacher=?";
        PreparedStatement pstmt=connStucs.prepareStatement(sql);
        pstmt.setInt(1,term);
        pstmt.setString(2,teacher);
        ResultSet rs=pstmt.executeQuery();
        List<Integer> cnoList=new ArrayList<Integer>();
        while(rs.next()){
            boolean isAdd=true;
           for(Integer comCno:cnoList){/**从结果中获取课程种类，如果要添加的结果前面添加过了设置isAdd=fslse,不允许添加到conList**/
            if (comCno==rs.getInt("cno"))
            {
                isAdd=false;
                break;
            }
           }
           if(isAdd)
               cnoList.add(rs.getInt("cno"));
        }
        return cnoList;
    }

    /**通过教师+学期查询教师当前学期负责的所有课程**/

    /**通过学期获得当前学年的所有课程名列表**/
    public List<String> searchCoursesName(int term)throws SQLException{
        CoursesService css=new CoursesService();
        String sql="select cno from tb_stu_courses where term=?";
        PreparedStatement pstmt=connStucs.prepareStatement(sql);
        pstmt.setInt(1,term);
        ResultSet rs=pstmt.executeQuery();
        List<String> courseNameList=new ArrayList<String>();
        while(rs.next()){
            /**通过查询到的课程号cno调用CoursesService的searchSingleCourseService方法映射成课程名，然后添加到课程名列表中**/
           courseNameList.add(css.searchSingleCourseService(rs.getInt("cno")).getC_name()) ;
        }
        return courseNameList;
    }
    /**通过学期获得当前学年的所有课程列表**/



}
