package odyssee_des.saveurs.repository;

import odyssee_des.saveurs.model.sql.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> { }