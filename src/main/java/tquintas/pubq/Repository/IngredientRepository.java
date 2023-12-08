package tquintas.pubq.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tquintas.pubq.Model.*;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<List<Ingredient>> findByType(IngredientType type);
    Optional<List<Ingredient>> findByName(String name);
    Optional<Ingredient> findByNameAndVolume(String name, double volume);
}
