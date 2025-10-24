package odyssee_des.saveurs.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import odyssee_des.saveurs.inc.CommandesStatus;
import odyssee_des.saveurs.model.sql.Commande;
import odyssee_des.saveurs.repository.CommandeRepository;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepo;
    // private CommandesStatus commandeStatus;
    // @Autowired
    // private CommandeDishesRepository commandeDishesRepo;

    public Commande createCommande(Commande commande) {
        commande.setDate(LocalDateTime.now());
        return commandeRepo.save(commande);
    }

    public List<Commande> getAllCommandes() {
        return commandeRepo.findAll();
    }

    public Commande getCommandeById(Long id) {
        return commandeRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Commande non trouvée"));
    }

    public Commande updateCommande(Commande commande) {
        if(commande.getIdCommande() != 0 && commandeRepo.existsById(commande.getIdCommande())) {
            return commandeRepo.save(commande);
        }
        else {
            throw new EntityNotFoundException("Commande non existante");
        }
    }

    public void deleteCommande(Long id) {
        commandeRepo.deleteById(id);
    }

    public Commande expedierCommande(Long id){
        Commande commande = commandeRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Commande non trouvée"));    
        commande.setStatus(CommandesStatus.EXPEDIEE);
        return commandeRepo.save(commande);
    }

    public Commande livrerCommande(Long id){
        Commande commande = commandeRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Commande non trouvée"));
        commande.setStatus(CommandesStatus.LIVREE);
        return commandeRepo.save(commande); 
    }

    public Commande annulerCommande(Long id){
        Commande co = commandeRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Commande non trouvée"));
        co.setStatus(CommandesStatus.ANNULEE);
        return commandeRepo.save(co);
    }
}