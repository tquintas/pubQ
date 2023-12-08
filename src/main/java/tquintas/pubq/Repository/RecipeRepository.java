package tquintas.pubq.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tquintas.pubq.Model.*;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Optional<List<Recipe>> findByAuthor(User user);
}
