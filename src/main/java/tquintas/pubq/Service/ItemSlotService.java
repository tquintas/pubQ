package tquintas.pubq.Service;

import tquintas.pubq.Model.ItemSlot;
import tquintas.pubq.Model.Slot;

import java.util.List;

public interface ItemSlotService {
    ItemSlot createItemSlot(ItemSlot itemSlot);
    ItemSlot getItemSlot(ItemSlot itemSlot);
    ItemSlot updateItemSlot(ItemSlot itemSlot);
    void deleteItemSlot(ItemSlot itemSlot);
    List<ItemSlot> getItemSlotBySlot(Slot slot);
}
