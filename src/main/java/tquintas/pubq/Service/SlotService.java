package tquintas.pubq.Service;

import tquintas.pubq.Model.Recipe;
import tquintas.pubq.Model.Slot;

import java.util.List;

public interface SlotService {
    Slot createSlot(Slot slot);
    Slot getSlot(Slot slot);
    Slot updateSlot(Slot slot);
    void deleteSlot(Slot slot);
    List<Slot> getAllByRecipe(Recipe recipe);
    Slot getSlotByRecipeAndIndex(Recipe recipe, int index);
}
