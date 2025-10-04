package odyssee_des.saveurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import odyssee_des.saveurs.model.sql.Personnel;

public interface PersonnelRepository extends JpaRepository<Personnel,Long>{

}
