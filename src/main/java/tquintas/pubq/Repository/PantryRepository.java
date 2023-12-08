package tquintas.pubq.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tquintas.pubq.Model.Pantry;
import tquintas.pubq.Model.User;

import java.util.Optional;

public interface PantryRepository extends JpaRepository<Pantry, Long> {
    Optional<Pantry> findByUser(User user);
}
