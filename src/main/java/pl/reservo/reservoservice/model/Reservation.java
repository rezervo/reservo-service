package pl.reservo.reservoservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.reservo.reservoservice.constants.ReservationStatus;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime starTime;
    private LocalDateTime endTime;
    private ReservationStatus status;
    private String notes;
    private boolean isAvailable;
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;
   @ManyToOne
   @JoinColumn(name = "company_id")
   private Company company;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
