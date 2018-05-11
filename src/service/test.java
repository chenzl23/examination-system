package service;
import dao.UsersDao;
import model.Users;

import java.util.List;
import java.util.ArrayList;

import java.sql.SQLException;

public class test {
    public static void main(String args[]) throws SQLException {
        UsersDao u=new UsersDao();
        //add
        Users uTest0=new Users();
        uTest0.setId("002");
        uTest0.setPasswd("password2");
        uTest0.setRole_id(2);
        u.addUsers (uTest0) ;
        //update
        Users uTest1=new Users();
        uTest1.setId("001");
        uTest1.setPasswd("password2");
        uTest1.setRole_id(2);
        u.updateUsers(uTest1);
        //delete
       String id="001";
     //u.deleteUsers(id);

       //searchSingle
       String id2="1";
      u.deleteUsers(id2);
       System.out.println(u.searchSingle(id).getId()
               + " "+u.searchSingle(id).getPasswd()+" "+u.searchSingle(id).getRole_id()+"\n");
        ///search
        List<Users> userLTest;
        userLTest=u.search();
        for(Users i:userLTest){
            String strP=i.getId()+" "+i.getPasswd()+" "+i.getRole_id()+"\n";
            System.out.println(strP);
        }
    }

}
