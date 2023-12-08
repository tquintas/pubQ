package tquintas.pubq.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tquintas.pubq.Model.Log;
import tquintas.pubq.Model.User;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface LogRepository extends JpaRepository<Log, Long> {
    Optional<List<Log>> findByDateBetween(Date date, Date date2);
    Optional<List<Log>> findByUser(User user);
}
