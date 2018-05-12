package service;
import dao.MajorDao;
import model.Major;

import java.sql.SQLException;

/**
 * @author by Lxp
 * @// TODO: 2018/5/10
 */
public class MajorService {
    MajorDao mjd=new MajorDao();

    /****searchMajorById****/
    public Major searchMajorNameService(int m_id)throws SQLException{
        return mjd.searchMajorName(m_id);
    }
    /****searchMajorByName****/
    public Major searchMajorIdService(String m_name)throws SQLException{
        return mjd.searchMajorId(m_name);
    }
}
