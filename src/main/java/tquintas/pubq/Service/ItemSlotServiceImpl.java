package tquintas.pubq.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tquintas.pubq.Model.ItemSlot;
import tquintas.pubq.Model.Slot;
import tquintas.pubq.Repository.ItemSlotRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemSlotServiceImpl implements ItemSlotService {
    private ItemSlotRepository itemSlotRepository;
    @Override
    public ItemSlot createItemSlot(ItemSlot itemSlot) {
        return itemSlotRepository.save(itemSlot);
    }

    @Override
    public ItemSlot getItemSlot(ItemSlot itemSlot) {
        return itemSlotRepository.findById(itemSlot.getId()).orElseThrow();
    }

    @Override
    public ItemSlot updateItemSlot(ItemSlot itemSlot) {
        ItemSlot existingItemSlot = itemSlotRepository.findById(itemSlot.getId()).orElseThrow();
        existingItemSlot.setDescription(itemSlot.getDescription());
        existingItemSlot.setSlot(itemSlot.getSlot());
        existingItemSlot.setQuantity(itemSlot.getQuantity());
        existingItemSlot.setPriority(itemSlot.getPriority());
        existingItemSlot.setIngredient(itemSlot.getIngredient());
        return itemSlotRepository.save(existingItemSlot);
    }

    @Override
    public void deleteItemSlot(ItemSlot itemSlot) {
        itemSlotRepository.deleteById(itemSlot.getId());
    }

    @Override
    public List<ItemSlot> getItemSlotBySlot(Slot slot) {
        return itemSlotRepository.findBySlot(slot).orElseThrow();
    }
}
