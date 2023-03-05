package pl.reservo.reservoservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.reservo.reservoservice.constants.Profession;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private Profession profession;
    @OneToOne
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    private ApplicationUser user;
}
