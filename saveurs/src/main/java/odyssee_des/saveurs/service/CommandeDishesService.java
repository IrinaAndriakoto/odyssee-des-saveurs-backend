package odyssee_des.saveurs.service;

import odyssee_des.saveurs.model.sql.CommandeDishes;
import odyssee_des.saveurs.repository.CommandeDishesRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CommandeDishesService {
    private final CommandeDishesRepository repository;

    @Autowired
    public CommandeDishesService(CommandeDishesRepository repository) {
        this.repository = repository;
    }

    public List<CommandeDishes> getAllCommandeDishes() {
        return repository.findAll();
    }
    public Optional<CommandeDishes> getCommandeDishesById(Long id) {
        return repository.findById(id);
    }
    public CommandeDishes addCommandeDishes(CommandeDishes cd) {
        return repository.save(cd);
    }
    public CommandeDishes updateCommandeDishes(CommandeDishes cd) {
        if(cd.getId() != 0 && repository.existsById(cd.getId())) {
            return repository.save(cd);
        }
        else {
            throw new EntityNotFoundException("CommandeDishes non existant.");
        }
    }
    public void deleteCommandeDishes(Long id) {
        repository.deleteById(id);
    }
}