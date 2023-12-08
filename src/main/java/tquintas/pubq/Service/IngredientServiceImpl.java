package tquintas.pubq.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tquintas.pubq.Model.Ingredient;
import tquintas.pubq.Model.IngredientType;
import tquintas.pubq.Repository.IngredientRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    private IngredientRepository ingredientRepository;
    @Override
    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient getIngredient(Ingredient ingredient) {
        return ingredientRepository.findById(ingredient.getId()).orElseThrow();
    }

    @Override
    public Ingredient updateIngredient(Ingredient ingredient) {
        Ingredient existingIngredient = ingredientRepository.findById(ingredient.getId()).orElseThrow();
        existingIngredient.setType(ingredient.getType());
        existingIngredient.setName(ingredient.getName());
        existingIngredient.setVolume(ingredient.getVolume());
        existingIngredient.setPrice(ingredient.getPrice());
        existingIngredient.setAlcohol(ingredient.getAlcohol());
        return ingredientRepository.save(existingIngredient);
    }

    @Override
    public void deleteIngredient(Ingredient ingredient) {
        ingredientRepository.deleteById(ingredient.getId());
    }

    @Override
    public List<Ingredient> getAllByIngredientType(IngredientType type) {
        return ingredientRepository.findByType(type).orElseThrow();
    }

    @Override
    public List<Ingredient> getAllByName(String name) {
        return ingredientRepository.findByName(name).orElseThrow();
    }

    @Override
    public Ingredient getIngredientByNameAndVolume(String name, double volume) {
        return ingredientRepository.findByNameAndVolume(name, volume).orElseThrow();
    }
}
