package service;
import  dao.UsersDao;
import model.Users;

import java.sql.SQLException;
import java.util.List;

public class UsersService {
      UsersDao ud=new UsersDao();
      /**add**/
      public boolean addService(Users u)throws SQLException {
          return ud.addUsers(u);
      }
      /**update**/
    public boolean updateService(Users u)throws SQLException{
          return ud.updateUsers(u);
    }
    /**delete**/
    public boolean deleteService(String id)throws SQLException{
          return ud.deleteUsers(id);
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
