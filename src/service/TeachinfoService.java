package service;
import dao.TeachinfoDao;
import model.Teachinfo;

import java.sql.SQLException;
import java.util.List;

public class TeachinfoService {
    TeachinfoDao td=new TeachinfoDao();

    /**addTeachinfo**/
    public boolean addTeachinfoService(Teachinfo t)throws SQLException{
        return td.addTeachinfo(t);
    }
    /**updateTeachinfo**/
    public boolean updateTeachinfoService(Teachinfo t)throws SQLException{
        return td.updateTeachinfo(t);
    }
    /**deleteTeachinfo**/
    public boolean deleteTeachinfoService(String t_id)throws SQLException{
        return td.deleteTeachinfo(t_id);
    }
    /**searchSingleTeachinfo**/
    public Teachinfo searchSingleTeachinfoService(String t_id)throws SQLException{
        return td.searchSingleTeachinfo(t_id);
    }
    /**searchAllTeachinfo**/
    public List<Teachinfo> searchAllTeachinfoService()throws SQLException{
        return td.searchAllTeachinfo();
    }
    /**searchTeachinfoByName**/
    public Teachinfo searchTeachinfoByNameService(String t_name)throws SQLException{
        return td.searchTeachinfoByName(t_name);
    }


}
