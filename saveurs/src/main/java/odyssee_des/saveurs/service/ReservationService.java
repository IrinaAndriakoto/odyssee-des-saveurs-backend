package odyssee_des.saveurs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityNotFoundException;
import odyssee_des.saveurs.model.sql.Reservation;
import odyssee_des.saveurs.repository.ReservationRepository;

public class ReservationService {
    private final ReservationRepository resaRepo;

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

    public Reservation udpateReservation(Reservation rs){
        if(rs.getId() != 0 && resaRepo.existsById(rs.getId())){
            return resaRepo.save(rs);
        } else {
            throw new EntityNotFoundException("La reservation n'existe pas.");
        }
    }

    public void deleteReservation(Long id){
        resaRepo.deleteById(id);
    }
}
