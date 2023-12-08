package tquintas.pubq.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tquintas.pubq.Model.*;

import java.util.List;
import java.util.Optional;

public interface ItemSlotRepository extends JpaRepository<ItemSlot, Long> {
    Optional<List<ItemSlot>> findBySlot(Slot slot);
}
