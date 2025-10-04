package odyssee_des.saveurs.model.sql;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "produit_nom", nullable = false)
    public String produitNom;

    public Integer quantite;

    @Column(name = "date_insertion")
    public LocalDateTime dateInsertion = LocalDateTime.now();
}