package odyssee_des.saveurs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import odyssee_des.saveurs.dto.CommandeDishDTO;
import odyssee_des.saveurs.model.sql.Commande;
import odyssee_des.saveurs.model.sql.CommandeDishes;
import odyssee_des.saveurs.model.sql.Dishes;
import odyssee_des.saveurs.repository.CommandeDishesRepository;
import odyssee_des.saveurs.repository.CommandeRepository;
import odyssee_des.saveurs.repository.DishesRepository;

@Service
public class CommandeDishesService {
    
    private final CommandeDishesRepository repository;

    @Autowired
    private DishesRepository dishesRepo;

    @Autowired
    private CommandeRepository commandeRepo;

    @Autowired
    public CommandeDishesService(CommandeDishesRepository repository) {
        this.repository = repository;
    }

    public List<CommandeDishDTO> getAllCommandeDishes() {
        return repository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    public Optional<CommandeDishDTO> getCommandeDishesById(Long id) {
        return repository.findById(id).map(this::toDTO);
    }

    public List<CommandeDishDTO> getAllDishesByCommandeId(Long commandeId){
        return repository.findByCommande_Id(commandeId).stream()
            .map(this::toDTO)
            .toList();
    }

    public CommandeDishDTO addCommandeDishes(CommandeDishDTO dto) {
        CommandeDishes cd = new CommandeDishes();
        if (dto.getDishId() != null) {
            Dishes dish = dishesRepo.findById(dto.getDishId())
                .orElseThrow(() -> new EntityNotFoundException("Dish non trouvé"));
            cd.setDish(dish);
        }
        if (dto.getCommandeId() != null) {
            Commande commande = commandeRepo.findById(dto.getCommandeId())
                .orElseThrow(() -> new EntityNotFoundException("Commande non trouvée"));
            cd.setCommande(commande);
        }
        cd.setQuantite(dto.getQuantite());
        CommandeDishes saved = repository.save(cd);
        return toDTO(saved);
    }

    public CommandeDishDTO updateCommandeDishes(CommandeDishDTO dto) {
        if(dto.getId() != null && repository.existsById(dto.getId())) {
            CommandeDishes cd = dtoToEntity(dto);
            CommandeDishes saved = repository.save(cd);
            return toDTO(saved);
        } else {
            throw new EntityNotFoundException("CommandeDishes non existant.");
        }
    }

    public void deleteCommandeDishes(Long id) {
        repository.deleteById(id);
    }

    private CommandeDishDTO toDTO(CommandeDishes cd) {
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
    private CommandeDishes dtoToEntity(CommandeDishDTO dto) {
        CommandeDishes cd = new CommandeDishes();
        cd.setId(dto.getId());
        cd.setQuantite(dto.getQuantite());

        if (dto.getDishId() != null) {
            Dishes dish = dishesRepo.findById(dto.getDishId())
                    .orElseThrow(() -> new EntityNotFoundException("Dish non trouvé"));
            cd.setDish(dish);
        }

        if (dto.getCommandeId() != null) {
            Commande commande = commandeRepo.findById(dto.getCommandeId())
                    .orElseThrow(() -> new EntityNotFoundException("Commande non trouvée"));
            cd.setCommande(commande);
        }
        return cd;
    }
}