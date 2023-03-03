package pl.reservo.reservoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.reservo.reservoservice.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
