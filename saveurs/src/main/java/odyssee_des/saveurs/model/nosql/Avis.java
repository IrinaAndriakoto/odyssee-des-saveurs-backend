package odyssee_des.saveurs.model.nosql;

import jakarta.persistence.Id;
import java.time.LocalDateTime;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "avis")
public class Avis {
    @Id
    private String id;
    private String username;
    private String email_user;
    private String commentaire;
    private int note;
    private LocalDateTime date;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String u){
        this.username = u;
    }
    public String getEmailUser(){
        return email_user;
    }
    public void setEmailUser(String eu){
        this.email_user = eu;
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
