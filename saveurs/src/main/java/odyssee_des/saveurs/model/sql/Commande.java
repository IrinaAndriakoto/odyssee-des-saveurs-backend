package odyssee_des.saveurs.model.sql;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Long id;

    // relation vers Table (existante) - optionnel, adapte si tu préfères stocker id seulement
    @ManyToOne
    @JoinColumn(name = "table_id")
    public Tables table_id;

    private String client; 

    public LocalDateTime date = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CommandesStatus status = CommandesStatus.EN_ATTENTE;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<CommandeDishes> commandeDishes = new ArrayList<>();

    public Commande(){}
    
    public Long getIdCommande() {
        return this.id;
    }
    public void setIdCommande(Long idCommande) {
        this.id = idCommande;
    }

    public Tables getTable() {
        return this.table_id;
    }
    public void setTable(Tables table) {
        this.table_id = table;
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