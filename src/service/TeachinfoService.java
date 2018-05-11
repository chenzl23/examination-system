package service;
import dao.TeachinfoDao;
import model.Teachinfo;

import java.sql.SQLException;
import java.util.List;

public class TeachinfoService {
    TeachinfoDao td=new TeachinfoDao();
    /**addTeachinfo**/
    public void addTeachinfoService(Teachinfo t)throws SQLException{
        td.addTeachinfo(t);
    }
    /**updateTeachinfo**/
    public void updateTeachinfoService(Teachinfo t)throws SQLException{
        td.updateTeachinfo(t);
    }
    /**deleteTeachinfo**/
    public void deleteTeachinfoService(String id)throws SQLException{
        td.deleteUsers(id);
    }
    /**searchSingleTeachinfo**/
    public Teachinfo searchSingleTeachinfoService(String id)throws SQLException{
        return td.searchSingleTeachinfo(id);
    }
    /**searchAllTeachinfo**/
    public List<Teachinfo> searchAllTeachinfoService()throws SQLException{
        return td.searchAllTeachinfo();
    }
}
