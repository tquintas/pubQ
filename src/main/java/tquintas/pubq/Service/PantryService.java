package tquintas.pubq.Service;

import tquintas.pubq.Model.Pantry;
import tquintas.pubq.Model.User;

public interface PantryService {
    Pantry createPantry(Pantry pantry);
    Pantry getPantry(Pantry pantry);
    Pantry updatePantry(Pantry pantry);
    void deletePantry(Pantry pantry);
    Pantry getPantryByUser(User user);
}
