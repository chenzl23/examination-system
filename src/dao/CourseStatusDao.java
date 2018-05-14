package dao;
import model.CourseStaus;
/**
 * @author by Lxp
 * @// TODO: 2018/5/9
 */
import java.sql.*;
public class CourseStatusDao {
    Connection connCst=(new DBUtil()).getConnection();

    /**通过状态id查询课程状态**/
    public CourseStaus searchCourseStatus(int cs_id)throws SQLException{
        CourseStaus courseStaus=null;
        String sql="select * from tb_course_status where id=?";
        PreparedStatement pstmt= connCst.prepareStatement(sql);
        pstmt.setInt(1,cs_id);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
           courseStaus=new CourseStaus();
           courseStaus.setCs_id(rs.getInt("id"));
           courseStaus.setCs_name(rs.getString("name"));
        }
        return courseStaus;
    };
    /**通过状态id查询课程状态**/
}
