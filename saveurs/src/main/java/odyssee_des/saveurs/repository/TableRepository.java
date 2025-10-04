package odyssee_des.saveurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import odyssee_des.saveurs.model.sql.Table;

public interface TableRepository extends JpaRepository<Table,Long>{
    
}
