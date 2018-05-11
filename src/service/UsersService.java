package service;
import  dao.UsersDao;
import model.Users;

import java.sql.SQLException;
import java.util.List;

public class UsersService {
      UsersDao ud=new UsersDao();
      /**add**/
      public void addService(Users u)throws SQLException {
          ud.addUsers(u);
      }
      /**update**/
    public void updateService(Users u)throws SQLException{
          ud.updateUsers(u);
    }
    /**delete**/
    public void deleteService(String id)throws SQLException{
          ud.deleteUsers(id);
    }
    /**searchSingle**/
    public Users searchSingleService(String id)throws SQLException{
          return ud.searchSingle(id);
    }
    /**search**/
    public List<Users> searchService()throws SQLException{
          return ud.search();
    }

}
