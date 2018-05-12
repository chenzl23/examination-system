package service;
import dao.CourseStatusDao;
import model.CourseStaus;

import java.sql.SQLException;

/**
 * @author by Lxp
 * @// TODO: 2018/5/10
 */
public class CourseStausService {
    CourseStatusDao cstd=new CourseStatusDao();
    /****searchCourseStatus****/
    public CourseStaus searchCourseStatusService(int cs_id)throws SQLException {
        return cstd.searchCourseStatus(cs_id);
    }
}
