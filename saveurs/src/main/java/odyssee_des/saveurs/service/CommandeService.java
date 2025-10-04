package odyssee_des.saveurs.service;

import odyssee_des.saveurs.model.sql.Commande;
import java.util.List;
import java.util.Optional;

public interface CommandeService {
    List<Commande> getAll();
    Optional<Commande> getById(Long id);
    Commande create(Commande c);
    Commande update(Long id, Commande c);
    void delete(Long id);
}