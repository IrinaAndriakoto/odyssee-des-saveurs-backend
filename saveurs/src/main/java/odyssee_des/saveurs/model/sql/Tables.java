package odyssee_des.saveurs.model.sql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tables {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String nom_table;
    private int nb_place;
    private boolean dispo;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom_table() {
        return nom_table;
    }
    public void setNom_table(String nom_table) {
        this.nom_table = nom_table;
    }
    public int getNb_place() {
        return nb_place;
    }
    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }
    public boolean isDispo() {
        return dispo;
    }
    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }

    
}
