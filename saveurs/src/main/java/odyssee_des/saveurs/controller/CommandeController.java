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

import odyssee_des.saveurs.model.sql.Commande;
import odyssee_des.saveurs.service.CommandeService;

@RestController
@RequestMapping("/commandes")
public class CommandeController {
    private final CommandeService service;
    public CommandeController(CommandeService service) { this.service = service; }

    @GetMapping("/getAll")
    public ResponseEntity<List<Commande>> getAllCommandes() { return ResponseEntity.ok(service.getAllCommandes()); }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        Commande commande = service.getCommandeById(id);
        if (commande != null) {
            return ResponseEntity.ok(commande);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Commande> createCommande(@RequestBody Commande c) {
        Commande created = service.createCommande(c);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Commande> updateCommande(@PathVariable Long id, @RequestBody Commande c) {
        c.setIdCommande(id);
        Commande updated = service.updateCommande(c);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        service.deleteCommande(id);
        return ResponseEntity.noContent().build();
    }
}