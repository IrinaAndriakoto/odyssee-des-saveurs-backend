package odyssee_des.saveurs.service;

import odyssee_des.saveurs.model.sql.CommandeDishes;
import odyssee_des.saveurs.repository.CommandeDishesRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeDishesServiceImpl implements CommandeDishesService {
    private final CommandeDishesRepository repo;
    public CommandeDishesServiceImpl(CommandeDishesRepository repo) { this.repo = repo; }

    @Override public List<CommandeDishes> getAll() { return repo.findAll(); }
    @Override public Optional<CommandeDishes> getById(Long id) { return repo.findById(id); }
    @Override public CommandeDishes create(CommandeDishes cd) { return repo.save(cd); }
    @Override public CommandeDishes update(Long id, CommandeDishes cd) { cd.id = id; return repo.save(cd); }
    @Override public void delete(Long id) { repo.deleteById(id); }
}