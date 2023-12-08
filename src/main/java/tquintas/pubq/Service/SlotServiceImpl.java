package tquintas.pubq.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tquintas.pubq.Model.Recipe;
import tquintas.pubq.Model.Slot;
import tquintas.pubq.Repository.SlotRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SlotServiceImpl implements SlotService {
    private SlotRepository slotRepository;
    @Override
    public Slot createSlot(Slot slot) {
        return slotRepository.save(slot);
    }

    @Override
    public Slot getSlot(Slot slot) {
        return slotRepository.findById(slot.getId()).orElseThrow();
    }

    @Override
    public Slot updateSlot(Slot slot) {
        Slot existingSlot = slotRepository.findById(slot.getId()).orElseThrow();
        existingSlot.setIndex(slot.getIndex());
        return slotRepository.save(existingSlot);
    }

    @Override
    public void deleteSlot(Slot slot) {
        slotRepository.deleteById(slot.getId());
    }

    @Override
    public List<Slot> getAllByRecipe(Recipe recipe) {
        return slotRepository.findByRecipeOrderByIndex(recipe).orElseThrow();
    }

    @Override
    public Slot getSlotByRecipeAndIndex(Recipe recipe, int index) {
        return slotRepository.findByRecipeAndIndex(recipe, index).orElseThrow();
    }
}
