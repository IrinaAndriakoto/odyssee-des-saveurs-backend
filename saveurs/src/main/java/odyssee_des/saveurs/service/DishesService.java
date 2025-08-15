package odyssee_des.saveurs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityNotFoundException;
import odyssee_des.saveurs.model.sql.Dishes;
import odyssee_des.saveurs.repository.DishesRepository;

public class DishesService {
    private final DishesRepository dsh;

    @Autowired
    public DishesService(DishesRepository dr){
        this.dsh = dr;
    }
    
    public List<Dishes> getAllDishes() {
        return dsh.findAll();
    }

    public Dishes getDishById(Long id){
        return dsh.findById(id).orElse(null);
    }

    public Dishes addDish(Dishes d){
        return dsh.save(d);
    }

    public Dishes updateDish(Dishes d){
        if(d.getId() != 0 && dsh.existsById(d.getId())){
            return dsh.save(d);
        } else {
            throw new EntityNotFoundException("Le plat que vous voulez modifier n'existe pas");
        }
    }

    public void deleteDishes(Long id){
        dsh.deleteById(id);
    }
}
