package odyssee_des.saveurs.model.sql;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import odyssee_des.saveurs.inc.CommandesStatus;


@Entity
@Table(name = "commandes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    // relation vers Table (existante) - optionnel, adapte si tu préfères stocker id seulement
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "table_id")
    private Tables table;

    private String client; 

    private LocalDateTime date = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CommandesStatus status = CommandesStatus.EN_ATTENTE;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true,fetch=FetchType.EAGER)
    @JsonManagedReference
    private List<CommandeDishes> commandeDishes = new ArrayList<>();

    public Commande(){}
    
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Tables getTable() {
        return this.table;
    }
    public void setTable(Tables table) {
        this.table = table;
    }

    public String getClient() {
        return this.client;
    }
    public void setClient(String client) {
        this.client = client;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public CommandesStatus getStatus() {
        return status;
    }
    public void setStatus(CommandesStatus status) {
        this.status = status;
    }

    public List<CommandeDishes> getCommandeDishes() {
        return this.commandeDishes;
    }
    public void setCommandeDishes(List<CommandeDishes> commandeDishes) {
        this.commandeDishes = commandeDishes;
    }
}