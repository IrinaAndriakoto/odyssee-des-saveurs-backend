package odyssee_des.saveurs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeDishDTO {
    private Long id;
    private Long dishId;
    private String dishName;
    private Double dishPrix;      // (optionnel) pour afficher le prix dans Angular
    private Integer quantite;
    private Long commandeId;
}