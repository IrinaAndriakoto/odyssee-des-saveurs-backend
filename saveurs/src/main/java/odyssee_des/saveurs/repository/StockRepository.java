package odyssee_des.saveurs.repository;

import odyssee_des.saveurs.model.sql.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> { }