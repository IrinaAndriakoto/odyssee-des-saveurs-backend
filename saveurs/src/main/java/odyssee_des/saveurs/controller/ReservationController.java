package odyssee_des.saveurs.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import odyssee_des.saveurs.model.sql.Reservation;
import odyssee_des.saveurs.service.ReservationService;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
// private final Logger logger = LoggerFactory.getLogger(ReservationService.class);

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Reservation>> getAll() {
        List<Reservation> reservations = reservationService.getAllReservations();
        if(reservations != null && !reservations.isEmpty()){
            return new ResponseEntity<>(reservations, HttpStatus.OK);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getById(@PathVariable Long id){
        Reservation r = reservationService.getReservationById(id);
        if(r != null){
            return new ResponseEntity<>(r, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/postReservation")
    public ResponseEntity<Reservation> create(@RequestBody Reservation reservation) {
        Reservation r = reservationService.addReservation(reservation);
        return new ResponseEntity<>(r, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Reservation> update(@PathVariable Long id, @RequestBody Reservation reservation) {
        reservation.setId(id);
        Reservation updatedReservation = reservationService.updateReservation(reservation);
        return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteResponseEntity(@PathVariable long id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/validate/{id}")
    public ResponseEntity<Reservation> validateReservation(@PathVariable Long id) {
        Reservation validatedReservation = reservationService.validateReservation(id);
        return ResponseEntity.ok(validatedReservation);
    }

    @PutMapping("/refuse/{id}")
    public ResponseEntity<Reservation> refuseReservation(@PathVariable Long id) {
        // logger.info("Controller: refus de la réservation id={}", id);
        Reservation refusedReservation = reservationService.refusalReservation(id);
        return ResponseEntity.ok(refusedReservation);
    }
}