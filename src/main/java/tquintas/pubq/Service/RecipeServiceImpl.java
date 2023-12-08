package tquintas.pubq.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tquintas.pubq.Model.Recipe;
import tquintas.pubq.Model.User;
import tquintas.pubq.Repository.RecipeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {
    private RecipeRepository recipeRepository;
    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        Recipe existingRecipe = recipeRepository.findById(recipe.getId()).orElseThrow();
        existingRecipe.setName(recipe.getName());
        existingRecipe.setDescription(recipe.getDescription());
        existingRecipe.setSteps(recipe.getSteps());
        existingRecipe.setSlotList(recipe.getSlotList());
        return recipeRepository.save(existingRecipe);
    }

    @Override
    public void deleteRecipe(Recipe recipe) {
        recipeRepository.deleteById(recipe.getId());
    }

    @Override
    public List<Recipe> getAllByAuthor(User user) {
        return recipeRepository.findByAuthor(user).orElseThrow();
    }

    @Override
    public Recipe getRecipe(Recipe recipe) {
        return recipeRepository.findById(recipe.getId()).orElseThrow();
    }
}
