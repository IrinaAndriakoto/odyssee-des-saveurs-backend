package odyssee_des.saveurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import odyssee_des.saveurs.model.sql.Dishes;

public interface DishesRepository extends JpaRepository<Dishes,Long>{
    
}
