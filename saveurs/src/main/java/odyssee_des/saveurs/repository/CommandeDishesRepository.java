package odyssee_des.saveurs.repository;

import odyssee_des.saveurs.model.sql.CommandeDishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeDishesRepository extends JpaRepository<CommandeDishes, Long> { }