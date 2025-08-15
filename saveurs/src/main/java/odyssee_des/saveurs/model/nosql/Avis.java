package odyssee_des.saveurs.model.nosql;

import jakarta.persistence.Id;
import java.time.LocalDateTime;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "avis")
public class Avis {
    @Id
    private String id;
    private Long clientId;
    private String commentaire;
    private int note;
    private LocalDateTime date;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    public String getCommentaire() {
        return commentaire;
    }
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    public int getNote() {
        return note;
    }
    public void setNote(int note) {
        this.note = note;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
