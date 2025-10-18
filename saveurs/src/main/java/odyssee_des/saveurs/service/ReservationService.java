package odyssee_des.saveurs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import odyssee_des.saveurs.model.sql.Reservation;
import odyssee_des.saveurs.repository.ReservationRepository;
import odyssee_des.saveurs.inc.ReservationStatus;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

@Service
public class ReservationService {
    private final ReservationRepository resaRepo;
// private final Logger logger = LoggerFactory.getLogger(ReservationService.class);
    @Autowired
    public ReservationService(ReservationRepository rr){
        this.resaRepo = rr;
    }

    public List<Reservation> getAllReservations(){
        return resaRepo.findAll();
    }

    public Reservation getReservationById(Long id){
        return resaRepo.findById(id).orElse(null);
    }

    public Reservation addReservation(Reservation rs){
        return resaRepo.save(rs);
    }

    public Reservation updateReservation(Reservation rs){
        if(rs.getId() != 0 && resaRepo.existsById(rs.getId())){
            return resaRepo.save(rs);
        } else {
            throw new EntityNotFoundException("La reservation n'existe pas.");
        }
    }

    public void deleteReservation(Long id){
        resaRepo.deleteById(id);
    }

    public Reservation validateReservation(Long id) {
        Reservation reservation;
        reservation = resaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found"));
        reservation.setStatus(ReservationStatus.VALIDEE);
        return resaRepo.save(reservation);
    }

    public Reservation refusalReservation(Long id) {
    // logger.info("Refus de la réservation id={}", id);
    Reservation reservation = resaRepo.findById(id)
        .orElseThrow(() -> {
            // logger.error("Reservation id={} NOT FOUND pour refus", id);
            return new EntityNotFoundException("Reservation not found");
        });
    reservation.setStatus(ReservationStatus.REFUSEE);
    // logger.info("Reservation id={} refusée", id);
    return resaRepo.save(reservation);
}
}
