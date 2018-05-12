package dao;
import model.Roles;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by lxp
 * @// TODO: 2018/5/5
 */
public class RolesDao {
    Connection connRole=(new DBUtil()).getConnection();
    //添加一种权限
    public boolean addRoles(Roles r)throws SQLException{
        if(searchSingleRole(r.getRole_id())!=null) return false;
        else {
            String sql = "insert into tb_roles (role_id,role_name,permission) values(?,?,?)";
            PreparedStatement pstmt = connRole.prepareStatement(sql);
            pstmt.setInt(1, r.getRole_id());
            pstmt.setString(2, r.getRole_name());
            pstmt.setInt(3, r.getPermission());
            pstmt.execute();
            return true;
        }
    }
    /******************更新某个权限***********************/
    public boolean updateRoles(Roles r)throws SQLException{
        if(searchSingleRole(r.getRole_id())==null) return false;
        else {
            String sql = "update tb_roles set role_name=?,permission=? where role_id=?";
            PreparedStatement pstmt = connRole.prepareStatement(sql);
            pstmt.setString(1, r.getRole_name());
            pstmt.setInt(2, r.getPermission());
            pstmt.setInt(3, r.getRole_id());
            pstmt.execute();
            return true;
        }
    }
    /******************更新某个权限***********************/


    /******************删除某种权限***********************/
    public boolean  deleteRole(int role_id)throws SQLException{
        if(searchSingleRole(role_id)==null) return false;
        else {
            String sql = "delete from tb_roles where role_id=?";
            PreparedStatement pstmt = connRole.prepareStatement(sql);
            pstmt.setInt(1, role_id);
            pstmt.execute();
            return true;
        }
    }
    /******************删除某种权限***********************/


    /******************查找某个权限***********************/
    public Roles searchSingleRole(int role_id)throws  SQLException{
        Roles r=null;
        String sql="select * from tb_roles where role_id=?";
        PreparedStatement pstmt=connRole.prepareStatement(sql);
        pstmt.setInt(1,role_id);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            r=new Roles();
            r.setRole_id(rs.getInt("role_id"));
            r.setRole_name(rs.getString("role_name"));
            r.setPermission(rs.getInt("permission"));
        }
        return r;
    }
    /******************查找某个权限***********************/


    /******************查找所有权限***********************/
    public List<Roles>searchAllRoles()throws SQLException{
        String sql="select * from tb_roles";
        Statement stmt=connRole.createStatement();
        ResultSet rs= stmt.executeQuery(sql);
        List<Roles> rolesList=new ArrayList<Roles>();
        Roles r=null;
        while(rs.next()){
            r.setRole_id(rs.getInt("role_id"));
            r.setRole_name(rs.getString("role_name"));
            r.setPermission(rs.getInt("permission"));
            rolesList.add(r);
        }
        return rolesList;
    }

    /******************查找所有权限***********************/

}
