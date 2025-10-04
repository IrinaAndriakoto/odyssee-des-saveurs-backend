package odyssee_des.saveurs.service;

import odyssee_des.saveurs.model.sql.Commande;
import odyssee_des.saveurs.repository.CommandeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements CommandeService {
    private final CommandeRepository repo;
    public CommandeServiceImpl(CommandeRepository repo) { this.repo = repo; }

    @Override
    public List<Commande> getAll() { return repo.findAll(); }

    @Override
    public Optional<Commande> getById(Long id) { return repo.findById(id); }

    @Override
    public Commande create(Commande c) { return repo.save(c); }

    @Override
    public Commande update(Long id, Commande c) {
        c.id = id;
        return repo.save(c);
    }

    @Override
    public void delete(Long id) { repo.deleteById(id); }
}