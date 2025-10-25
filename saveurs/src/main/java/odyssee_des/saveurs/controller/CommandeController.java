package odyssee_des.saveurs.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import odyssee_des.saveurs.dto.CommandeDTO;
import odyssee_des.saveurs.service.CommandeService;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private final CommandeService service;

    public CommandeController(CommandeService service) { this.service = service; }

    @GetMapping("/getAll")
    public ResponseEntity<List<CommandeDTO>> getAllCommandes() { return ResponseEntity.ok(service.getAllCommandes()); }

    @GetMapping("/{id}")
    public ResponseEntity<CommandeDTO> getCommandeById(@PathVariable Long id) {
        CommandeDTO commande = service.getCommandeById(id);
        if (commande != null) {
            return ResponseEntity.ok(commande);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<CommandeDTO> createCommande(@RequestBody CommandeDTO c) {
        CommandeDTO created = service.createCommande(c);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CommandeDTO> updateCommande(@PathVariable Long id, @RequestBody CommandeDTO c) {
        c.setId(id);
        CommandeDTO updated = service.updateCommande(c);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id) {
        service.deleteCommande(id);
    }

    @PutMapping("/expedier/{id}")
    public ResponseEntity<CommandeDTO> expedierCommande(@PathVariable Long id) {
        CommandeDTO updated = service.expedierCommande(id);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/livrer/{id}")
    public ResponseEntity<CommandeDTO> livrerCommande(@PathVariable Long id) {
        CommandeDTO updated = service.livrerCommande(id);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/annuler/{id}")
    public ResponseEntity<CommandeDTO> annulerCommande(@PathVariable Long id) {
        CommandeDTO updated = service.annulerCommande(id);
        return ResponseEntity.ok(updated);
    }
}