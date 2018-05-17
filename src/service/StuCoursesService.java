package service;
import dao.StuCoursesDao;
import model.StuCourses;
import model.Courses;
import service.CoursesService;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
public class StuCoursesService {
    StuCoursesDao stuCoursesDao=new StuCoursesDao();

    /***添加新的选课***/
    public boolean addStuCourseService(StuCourses stuCourses)throws SQLException{/**可通过boolean判断是否添加成功**/
        return stuCoursesDao.addStuCourse(stuCourses);
    }
    /***仅仅根据选课sc_id更新选课***/
    public boolean updateStuCourseService(StuCourses stuCourses)throws SQLException{/**可通过boolean判断是否更新成功**/
        return stuCoursesDao.updateStuCourse(stuCourses);
    }
    /**仅仅根据选课sc_id删除选课**/
    public boolean deleteStuCourseService(int sc_id)throws SQLException{/**可通过boolean判断是否删除成功**/
        return stuCoursesDao.deleteStuCourse(sc_id);/**修改 bug：漏了返回值**/
    }
    /**通过选课sc_id查找选课信息**/
    public StuCourses searchStuCourseService(int sc_id)throws SQLException{
        return stuCoursesDao.searchStuCourse(sc_id);/**@// TODO: 2018/5/12  修改 bug：漏了返回值StuCourses**/
    }
    /**通过 学号+学期+课程名字查询选课信息（主要是学生查询成绩）,返回StuCourses类，
     * 需要使用时直接searchStuScoreService(sno,term,c_name).get方法 获得成绩**/
    public List<StuCourses> searchStuScoreService(String sno,int term,String c_name)throws SQLException{
        return stuCoursesDao.searchStuScore(sno);
    }
    /**通过 学期+教师名字+课程名字,（主要用于教师/管理员查询成绩）**/
    public List<StuCourses> getScoreByTeacherService(int term,String teacher,String c_name)throws SQLException{
        CoursesService css=new CoursesService();
        int cno=(css.searchCourseByNameService(c_name)).getC_id();//将课程名字映射到课程id
        return stuCoursesDao.getScoreByTeacher(term,teacher,cno);
    }
    /**通过教师名字获取其负责的所有课程及课程信息**/
    public List<Courses> getCoursesOfService(int term,String teacher)throws SQLException{
        CoursesService css=new CoursesService();
        List<Integer> cnoList=stuCoursesDao.getCoursesOf(term,teacher);
        List <Courses> coursesList=new ArrayList<Courses>();
        for(Integer cno:cnoList){
            coursesList.add(css.searchSingleCourseService(cno));
        }
        return coursesList;
    }
    /**通过学期获得当前学年的所有课程名列表,可通过该功能实现选定学年后限定课程列表**/
    public List<String> searchCoursesNameService(int term)throws SQLException{
        return stuCoursesDao.searchCoursesName(term);
    }
}
