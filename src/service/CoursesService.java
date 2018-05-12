package service;
import dao.CoursesDao;
import model.Courses;
import model.Teachinfo;
import service.TeachinfoService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author by Lxp
 * @// TODO: 2018/5/10 添加了通过教师id/名称获取其负责的课程信息的功能
 */
public class CoursesService {
    CoursesDao csd=new CoursesDao();

    /****addCourse****/
    public boolean addCourseService(Courses cs)throws SQLException {
       return csd.addCourse(cs);
    }
    /****updateCourse****/
    public boolean updateCourseService(Courses cs) throws SQLException {
     return csd.updateCourse(cs);
    }
    /****delteCourse****/
    public boolean deleteCourseService(int c_id)throws SQLException{
        return csd.delteCourse(c_id);
    }
    /*****searchSingleCourse****/
    public Courses searchSingleCourseService(int c_id)throws SQLException{
        return csd.searchSingleCourse(c_id);
    }
    /****searchCourseByname****/
    public Courses searchCourseByNameService(String c_name)throws SQLException{
        return csd.searchCourseByName(c_name);
    }
    /****searchAllCourse****/
    public List<Courses> searchAllCourseService()throws SQLException{
        return csd.searchAllCourse();
    }

    /**
     * @// TODO: 2018/5/9 22:52 新添加的通过教师id/名字查询其负责的课程信息的业务功能
     */
/**
 * @// TODO: 2018/5/11 21:44 删除了通过教师查询其负责的课程，已将该功能迁移到StuCoursesService中
 */


}
