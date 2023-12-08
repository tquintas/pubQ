package tquintas.pubq.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tquintas.pubq.Model.Pantry;
import tquintas.pubq.Model.User;
import tquintas.pubq.Repository.PantryRepository;

@Service
@AllArgsConstructor
public class PantryServiceImpl implements PantryService {
    private PantryRepository pantryRepository;
    @Override
    public Pantry createPantry(Pantry pantry) {
        return pantryRepository.save(pantry);
    }

    @Override
    public Pantry getPantry(Pantry pantry) {
        return pantryRepository.findById(pantry.getId()).orElseThrow();
    }

    @Override
    public Pantry updatePantry(Pantry pantry) {
        Pantry existingPantry = pantryRepository.findById(pantry.getId()).orElseThrow();
        existingPantry.setName(pantry.getName());
        existingPantry.setItemList(pantry.getItemList());
        return pantryRepository.save(existingPantry);
    }

    @Override
    public void deletePantry(Pantry pantry) {
        pantryRepository.deleteById(pantry.getId());
    }

    @Override
    public Pantry getPantryByUser(User user) {
        return pantryRepository.findByUser(user).orElseThrow();
    }
}
