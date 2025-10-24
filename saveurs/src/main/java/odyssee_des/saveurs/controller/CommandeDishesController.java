package odyssee_des.saveurs.controller;

import java.util.List;

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

import odyssee_des.saveurs.model.sql.CommandeDishes;
import odyssee_des.saveurs.service.CommandeDishesService;

@RestController
@RequestMapping("/commande-dishes")
public class CommandeDishesController {
    private final CommandeDishesService service;
    public CommandeDishesController(CommandeDishesService service) { this.service = service; }

    @GetMapping("/getAll")
    public ResponseEntity<List<CommandeDishes>> getAllCommandeDishes() { return ResponseEntity.ok(service.getAllCommandeDishes()); }

    @GetMapping("/{id}")
    public ResponseEntity<CommandeDishes> getCommandeDishesById(@PathVariable Long id) {
        return service.getCommandeDishesById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/dishes")
    public ResponseEntity<List<CommandeDishes>> getDishesByCommande(@PathVariable("id") Long id) {
        List<CommandeDishes> list = service.getAllDishesByCommandeId(id);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/add")
    public ResponseEntity<CommandeDishes> addCommandeDishes(@RequestBody CommandeDishes cd) {
        return ResponseEntity.status(201).body(service.addCommandeDishes(cd));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CommandeDishes> updateCommandeDishes(@PathVariable Long id, @RequestBody CommandeDishes cd) {
        cd.setId(id);
        CommandeDishes upt = service.updateCommandeDishes(cd);
        return new ResponseEntity<>(upt, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommandeDishes(@PathVariable Long id) {
        service.deleteCommandeDishes(id);
        return ResponseEntity.noContent().build();
    }
}