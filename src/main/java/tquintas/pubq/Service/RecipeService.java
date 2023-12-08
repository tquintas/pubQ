package tquintas.pubq.Service;

import tquintas.pubq.Model.Recipe;
import tquintas.pubq.Model.User;

import java.util.List;

public interface RecipeService {
    Recipe createRecipe(Recipe recipe);
    Recipe getRecipe(Recipe recipe);
    Recipe updateRecipe(Recipe recipe);
    void deleteRecipe(Recipe recipe);
    List<Recipe> getAllByAuthor(User user);
}
