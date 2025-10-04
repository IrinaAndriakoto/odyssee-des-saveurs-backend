package odyssee_des.saveurs.model.sql;

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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    public Table tableRef;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    public LocalDateTime date = LocalDateTime.now();

    // status simple; tu peux utiliser un enum si preferes
    public String status;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<CommandeDishes> items = new ArrayList<>();
}