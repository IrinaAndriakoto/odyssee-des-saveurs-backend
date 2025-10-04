package odyssee_des.saveurs.controller;

import java.util.List;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import odyssee_des.saveurs.model.sql.Dishes;
import odyssee_des.saveurs.service.DishesService;

@RestController
@RequestMapping("/dishes")
public class DishesController {
    private final DishesService dservice;

    @Autowired
    public DishesController(DishesService ds){
        this.dservice = ds;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Dishes>> getAllDishes(){
        List<Dishes> dishes = dservice.getAllDishes();
        if(dishes != null && !dishes.isEmpty()){
            return new ResponseEntity<>(dishes, HttpStatus.OK);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dishes> getDishById(@PathVariable Long id){
        Dishes dish = dservice.getDishById(id);
        if(dish != null){
            return new ResponseEntity<>(dish, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Dishes> addDish(@RequestBody Dishes d) {
        Dishes newDish = dservice.addDish(d);
        return new ResponseEntity<>(newDish, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Dishes> updateDish(@RequestBody Dishes d) {
        Dishes updatedDish = dservice.updateDish(d);
        return new ResponseEntity<>(updatedDish, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable long id) {
        dservice.deleteDishes(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
