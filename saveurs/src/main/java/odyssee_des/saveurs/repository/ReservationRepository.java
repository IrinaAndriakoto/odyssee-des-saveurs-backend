package odyssee_des.saveurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import odyssee_des.saveurs.model.sql.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    
}
