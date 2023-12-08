package tquintas.pubq.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tquintas.pubq.Model.Log;
import tquintas.pubq.Model.User;
import tquintas.pubq.Repository.LogRepository;

import java.sql.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class LogServiceImpl implements LogService {
    private LogRepository logRepository;
    @Override
    public Log createLog(Log log) {
        log.setDate(new Date(new java.util.Date().getTime()));
        return logRepository.save(log);
    }

    @Override
    public Log getLog(Log log) {
        return logRepository.findById(log.getId()).orElseThrow();
    }

    @Override
    public Log updateLog(Log log) {
        Log existingLog = logRepository.findById(log.getId()).orElseThrow();
        existingLog.setUser(log.getUser());
        existingLog.setDescription(log.getDescription());
        existingLog.setDate(new Date(new java.util.Date().getTime()));
        return logRepository.save(existingLog);
    }

    @Override
    public void deleteLog(Log log) {
        logRepository.deleteById(log.getId());
    }

    @Override
    public List<Log> getAllBetween(Date date, Date date2) {
        return logRepository.findByDateBetween(date, date2).orElseThrow();
    }

    @Override
    public List<Log> getAllByUser(User user) {
        return logRepository.findByUser(user).orElseThrow();
    }

    @Override
    public void insertLog(String message, User user) {
        Log log = new Log();
        log.setUser(user);
        log.setDescription(message);
        Log savedLog = createLog(log);
        System.out.println(savedLog);
    }

    @Override
    public void insertLog(String message) {
        Log log = new Log();
        log.setDescription(message);
        Log savedLog = createLog(log);
        System.out.println(savedLog);
    }
}
