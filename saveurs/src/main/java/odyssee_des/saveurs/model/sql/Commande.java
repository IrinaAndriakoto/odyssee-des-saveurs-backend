package odyssee_des.saveurs.model.sql;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


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

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user_id;

    public LocalDateTime date = LocalDateTime.now();

    public String status;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<CommandeDishes> commandeDishes = new ArrayList<>();


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

    public User getId_user() {
        return this.user_id;
    }
    public void setId_user(User id_user) {
        this.user_id = id_user;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public List<CommandeDishes> getCommandeDishes() {
        return this.commandeDishes;
    }
    public void setCommandeDishes(List<CommandeDishes> commandeDishes) {
        this.commandeDishes = commandeDishes;
    }
}