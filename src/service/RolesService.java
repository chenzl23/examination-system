package service;
import dao.RolesDao;
import model.Roles;

import java.sql.SQLException;
import java.util.List;

public class RolesService {
    RolesDao rd=new RolesDao();

    /**addRoles**/
    public boolean addRService(Roles r)throws SQLException {
        return rd.addRoles(r);
    }
    /**updateRoles**/
    public boolean updateRService(Roles r)throws SQLException{
       return rd.updateRoles(r);
    }
    /**deleteRoles**/
    public boolean deleteRService(int role_id)throws SQLException{
        return rd.deleteRole(role_id);
    }
    /**searchSingleRoles**/
  public Roles searchSRService(int role_id)throws  SQLException{/**@// TODO: 2018/5/12 修改 bug：漏了返回值 **/
        return rd.searchSingleRole(role_id);
  }
  /**searchAllRoles**/
    public List<Roles> searchARService()throws SQLException{
        return rd.searchAllRoles();
    }
}
