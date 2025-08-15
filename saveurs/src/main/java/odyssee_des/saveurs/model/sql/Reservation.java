package odyssee_des.saveurs.model.sql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import odyssee_des.saveurs.inc.ReservationStatus;

import java.sql.Date;
import java.sql.Time;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    private String fullname;
    private String email;
    private Double phone;
    private Integer partySize;
    private Date preferedDate;
    private Time preferedTime;
    private String specialRequests;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status = ReservationStatus.EN_ATTENTE;


    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Double getPhone() {
        return phone;
    }
    public void setPhone(Double phone) {
        this.phone = phone;
    }
    public Integer getPartySize() {
        return partySize;
    }
    public void setPartySize(Integer partySize) {
        this.partySize = partySize;
    }
    public Date getPreferedDate() {
        return preferedDate;
    }
    public void setPreferedDate(Date preferedDate) {
        this.preferedDate = preferedDate;
    }
    public Time getPreferedTime() {
        return preferedTime;
    }
    public void setPreferedTime(Time preferedTime) {
        this.preferedTime = preferedTime;
    }
    public String getSpecialRequests() {
        return specialRequests;
    }
    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

}
