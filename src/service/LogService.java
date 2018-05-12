package service;
import dao.LogDao;
import model.Log;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class LogService {
    LogDao lgd=new LogDao();

    /**addLog**/
    public boolean addLogService(Log lg)throws SQLException{
        return lgd.addLog(lg);
    }
    /**updateLog**/
    public boolean updateLogService(Log lg)throws SQLException{
        return lgd.updateLog(lg);
    }
    /**deleteLog**/
    public boolean deleteLog(int login_id)throws SQLException{
        return lgd.deleteLog(login_id);
    }
    /**searchSingleLog**/
    public Log searchSingleLogService(int login_id)throws SQLException{
        return lgd.searchSingleLog(login_id);
    }
    /**searchAllLog**/
    public List<Log> searchAllLogService()throws SQLException{
        return lgd.searchAllLog();
    }
}
