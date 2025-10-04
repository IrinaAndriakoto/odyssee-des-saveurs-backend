package odyssee_des.saveurs.controller;

import odyssee_des.saveurs.model.sql.CommandeDishes;
import odyssee_des.saveurs.service.CommandeDishesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande-dishes")
public class CommandeDishesController {
    private final CommandeDishesService service;
    public CommandeDishesController(CommandeDishesService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<CommandeDishes>> getAll() { return ResponseEntity.ok(service.getAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<CommandeDishes> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CommandeDishes> create(@RequestBody CommandeDishes cd) {
        return ResponseEntity.status(201).body(service.create(cd));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandeDishes> update(@PathVariable Long id, @RequestBody CommandeDishes cd) {
        return ResponseEntity.ok(service.update(id, cd));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}