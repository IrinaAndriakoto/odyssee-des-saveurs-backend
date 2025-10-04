package odyssee_des.saveurs.service;

import odyssee_des.saveurs.model.sql.CommandeDishes;
import java.util.List;
import java.util.Optional;

public interface CommandeDishesService {
    List<CommandeDishes> getAll();
    Optional<CommandeDishes> getById(Long id);
    CommandeDishes create(CommandeDishes cd);
    CommandeDishes update(Long id, CommandeDishes cd);
    void delete(Long id);
}