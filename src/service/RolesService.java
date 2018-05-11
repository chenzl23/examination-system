package service;
import dao.RolesDao;
import model.Roles;

import java.sql.SQLException;
import java.util.List;

public class RolesService {
    RolesDao rd=new RolesDao();

    /**addRoles**/
    public void addRService(Roles r)throws SQLException {
        rd.addRoles(r);
    }
    /**updateRoles**/
    public void updateRService(Roles r)throws SQLException{
        rd.updateRoles(r);
    }
    /**deleteRoles**/
    public void deleteRService(int role_id)throws SQLException{
        rd.deleteRole(role_id);
    }
    /**searchSingleRoles**/
  public void  searchSRService(int role_id)throws  SQLException{
        rd.searchSingleRole(role_id);
  }
  /**searchAllRoles**/
    public List<Roles> searchARService()throws SQLException{
        return rd.searchAllRoles();
    }
}
