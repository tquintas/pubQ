package tquintas.pubq.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tquintas.pubq.Model.*;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);
}
