package odyssee_des.saveurs.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeDTO {
    private Long id;
    private Long tableId;
    private String tableName;
    private String client;
    private LocalDateTime date;
    private String status; // Stocké comme String pour faciliter Angular

    private List<CommandeDishDTO> commandeDishes;
}