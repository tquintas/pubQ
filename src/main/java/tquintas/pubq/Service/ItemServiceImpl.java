package tquintas.pubq.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tquintas.pubq.Model.Item;
import tquintas.pubq.Model.Pantry;
import tquintas.pubq.Repository.ItemRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;
    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getItem(Item item) {
        return itemRepository.findById(item.getId()).orElseThrow();
    }

    @Override
    public Item updateItem(Item item) {
        Item existingItem = itemRepository.findById(item.getId()).orElseThrow();
        existingItem.setIngredient(item.getIngredient());
        existingItem.setQuantity(item.getQuantity());
        return itemRepository.save(existingItem);
    }

    @Override
    public void deleteItem(Item item) {
        itemRepository.deleteById(item.getId());
    }

    @Override
    public List<Item> getAllByPantry(Pantry pantry) {
        return itemRepository.findByPantry(pantry).orElseThrow();
    }
}
