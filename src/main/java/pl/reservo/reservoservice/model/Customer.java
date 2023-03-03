package pl.reservo.reservoservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    private ApplicationUser user;
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Reservation> reservations;

}
