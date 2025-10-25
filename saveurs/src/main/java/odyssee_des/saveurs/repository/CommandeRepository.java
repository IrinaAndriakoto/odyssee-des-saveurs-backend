package odyssee_des.saveurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import odyssee_des.saveurs.model.sql.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

 }