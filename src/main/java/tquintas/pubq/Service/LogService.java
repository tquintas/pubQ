package tquintas.pubq.Service;

import tquintas.pubq.Model.Log;
import tquintas.pubq.Model.User;

import java.sql.Date;
import java.util.List;

public interface LogService {
    Log createLog(Log log);
    Log getLog(Log log);
    Log updateLog(Log log);
    void deleteLog(Log log);
    List<Log> getAllBetween(Date date, Date date2);
    List<Log> getAllByUser(User user);
    void insertLog(String message, User user);
    void insertLog(String message);
}
