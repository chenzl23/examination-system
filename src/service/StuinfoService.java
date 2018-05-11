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
    public void addSService(Stuinfo si)throws SQLException{
        sd.addStuinfo(si);
    }
    /**updateStuinfo**/
    public void updateSService(Stuinfo si)throws SQLException{
        sd.updateStuinfo(si);
    }
    /**deleteStuinfo**/
    public void deleteSService(String id)throws SQLException{//删除某个学生
        sd.deleteStuinfo(id);
    }
    /**searchSingleStuinfo**/
    public Stuinfo searchSStuinfoService(String id)throws SQLException{//查找单个学生信息
        return sd.searchSingleStuinfo(id);
    }
    /**searchAllStuinfo**/
    public List<Stuinfo> searchAStuinfoService()throws SQLException{
        return sd.searchAllStuinfo();
    }

}
