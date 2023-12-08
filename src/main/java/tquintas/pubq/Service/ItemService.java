package tquintas.pubq.Service;

import tquintas.pubq.Model.Item;
import tquintas.pubq.Model.Pantry;

import java.util.List;

public interface ItemService {
    Item createItem(Item item);
    Item getItem(Item item);
    Item updateItem(Item item);
    void deleteItem(Item item);
    List<Item> getAllByPantry(Pantry pantry);
}
