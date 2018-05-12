package dao;
import model.Major;

import java.sql.*;

/**
 * @author by Lxp
 * @// TODO: 2018/5/10
 */
public class MajorDao {
    Connection connMjr=(new DBUtil()).getConnection();

    /**通过专业id查找专业名称**/
    public Major searchMajorName(int m_id)throws SQLException{
        Major mj=null;
        String sql="select * from tb_major where id=?";
        PreparedStatement pstmt=connMjr.prepareStatement(sql);
        pstmt.setInt(1,m_id);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            mj=new Major();
            mj.setM_id(rs.getInt("id"));
            mj.setM_name(rs.getString("name"));
        }
        return mj;
    }
    /**通过专业id查找专业名称**/

    /**通过专业名称查找专业id**/
    public Major searchMajorId(String m_name)throws SQLException{
        Major mj=null;
        String sql="select * from tb_major where name=?";
        PreparedStatement pstmt=connMjr.prepareStatement(sql);
        pstmt.setString(1,m_name);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            mj=new Major();
            mj.setM_id(rs.getInt("id"));
            mj.setM_name(rs.getString("name"));
        }
        return mj;
    }
    /**通过专业名称查找专业id**/

}
