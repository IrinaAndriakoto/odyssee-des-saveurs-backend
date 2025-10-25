package odyssee_des.saveurs.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import odyssee_des.saveurs.dto.CommandeDTO;
import odyssee_des.saveurs.dto.CommandeDishDTO;
import odyssee_des.saveurs.inc.CommandesStatus;
import odyssee_des.saveurs.model.sql.Commande;
import odyssee_des.saveurs.model.sql.CommandeDishes;
import odyssee_des.saveurs.model.sql.Tables;
import odyssee_des.saveurs.repository.CommandeRepository;
import odyssee_des.saveurs.repository.TableRepository;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepo;
    @Autowired
    private TableRepository tablesRepo;

    public CommandeDTO createCommande(CommandeDTO dto) {
        Commande commande = dtoToEntity(dto);
        commande.setDate(LocalDateTime.now());
        Commande saved = commandeRepo.save(commande);
        return toDTO(saved);
    }

    public List<CommandeDTO> getAllCommandes() {
        return commandeRepo.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    public CommandeDTO getCommandeById(Long id) {
        Commande commande = commandeRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Commande non trouvée"));
        return toDTO(commande);
    }

    public CommandeDTO updateCommande(CommandeDTO dto) {
        if (dto.getId() != null && commandeRepo.existsById(dto.getId())) {
            Commande commande = dtoToEntity(dto);
            Commande saved = commandeRepo.save(commande);
            return toDTO(saved);
        } else {
            throw new EntityNotFoundException("Commande non existante");
        }
    }

    public void deleteCommande(Long id) {
        commandeRepo.deleteById(id);
    }

    public CommandeDTO expedierCommande(Long id) {
        return changeStatus(id, CommandesStatus.EXPEDIEE);
    }
    public CommandeDTO livrerCommande(Long id) {
        return changeStatus(id, CommandesStatus.LIVREE);
    }
    public CommandeDTO annulerCommande(Long id) {
        return changeStatus(id, CommandesStatus.ANNULEE);
    }
    private CommandeDTO changeStatus(Long id, CommandesStatus status) {
        Commande commande = commandeRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Commande non trouvée"));
        commande.setStatus(status);
        return toDTO(commandeRepo.save(commande));
    }

    // ====== Mapping Entity <-> DTO ======
    private CommandeDTO toDTO(Commande commande) {
        CommandeDTO dto = new CommandeDTO();
        dto.setId(commande.getId());
        dto.setClient(commande.getClient());
        dto.setDate(commande.getDate());
        dto.setStatus(commande.getStatus() != null ? commande.getStatus().name() : null);

        if (commande.getTable() != null) {
            dto.setTableId(commande.getTable().getId());
            dto.setTableName(commande.getTable().getNom_table());
        }
        // Mapping "à la volée" des ligne commandeDishes
        if (commande.getCommandeDishes() != null) {
            dto.setCommandeDishes(
                commande.getCommandeDishes().stream()
                        .map(this::toDishDTO)
                        .toList()
            );
        }
        return dto;
    }
    private CommandeDishDTO toDishDTO(CommandeDishes cd) {
        CommandeDishDTO dto = new CommandeDishDTO();
        dto.setId(cd.getId());
        if (cd.getDish() != null) {
            dto.setDishId(cd.getDish().getId());
            dto.setDishName(cd.getDish().getNom());
            dto.setDishPrix(cd.getDish().getPrix());
        }
        if (cd.getCommande() != null) {
            dto.setCommandeId(cd.getCommande().getId());
        }
        dto.setQuantite(cd.getQuantite());
        return dto;
    }
    private Commande dtoToEntity(CommandeDTO dto) {
        Commande commande = new Commande();
        commande.setId(dto.getId());
        commande.setClient(dto.getClient());
        commande.setStatus(dto.getStatus() != null ?
                CommandesStatus.valueOf(dto.getStatus()) :
                CommandesStatus.EN_ATTENTE);

        // Prise en charge du JSON "table": { "id": X }
        if (dto.getTableId() != null) {
            Tables table = tablesRepo.findById(dto.getTableId())
                    .orElseThrow(() -> new EntityNotFoundException("Table non trouvée"));
            commande.setTable(table);
        }
        return commande;
    }
}