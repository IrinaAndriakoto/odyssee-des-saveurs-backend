package odyssee_des.saveurs.model.sql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "commande_dishes")
public class CommandeDishes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    public Commande commande;

    // Relation vers Dishes existant
    @ManyToOne
    @JoinColumn(name = "dish_id")
    public Dishes dish;

    public Integer quantite;
    public BigDecimal prix;
}