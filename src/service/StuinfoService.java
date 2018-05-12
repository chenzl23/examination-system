package service;
import dao.StuinfoDao;
import model.Stuinfo;

import java.sql.SQLException;
import java.util.List;

/**
 * @author by Lxp
 * @// TODO: 2018/5/8 17:33
 *
 */
public class StuinfoService {
    StuinfoDao sd=new StuinfoDao();
    /**addStuinfo**/
    public boolean addSService(Stuinfo si)throws SQLException{
       return sd.addStuinfo(si);
    }
    /**updateStuinfo**/
    public boolean updateSService(Stuinfo si)throws SQLException{
        return sd.updateStuinfo(si);
    }
    /**deleteStuinfo**/
    public boolean deleteSService(String s_id)throws SQLException{//删除某个学生
            return sd.deleteStuinfo(s_id);
    }
    /**searchSingleStuinfo**/
    public Stuinfo searchSStuinfoService(String s_id)throws SQLException{//查找单个学生信息
        return sd.searchSingleStuinfo(s_id);
    }
    /**searchAllStuinfo**/
    public List<Stuinfo> searchAStuinfoService()throws SQLException{
        return sd.searchAllStuinfo();
    }

}
