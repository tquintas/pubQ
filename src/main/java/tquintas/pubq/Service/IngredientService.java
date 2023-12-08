package tquintas.pubq.Service;

import tquintas.pubq.Model.Ingredient;
import tquintas.pubq.Model.IngredientType;

import java.util.List;

public interface IngredientService {
    Ingredient createIngredient(Ingredient ingredient);
    Ingredient getIngredient(Ingredient ingredient);
    Ingredient updateIngredient(Ingredient ingredient);
    void deleteIngredient(Ingredient ingredient);
    List<Ingredient> getAllByIngredientType(IngredientType type);
    List<Ingredient> getAllByName(String name);
    Ingredient getIngredientByNameAndVolume(String name, double volume);

}
