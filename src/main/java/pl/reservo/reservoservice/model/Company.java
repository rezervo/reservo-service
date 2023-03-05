package pl.reservo.reservoservice.model;

import jakarta.persistence.*;
import lombok.*;
import pl.reservo.reservoservice.constants.Profession;



@Entity
@DiscriminatorValue("company")
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Company extends ApplicationUser {

    private String name;
    private String phoneNumber;
    private Profession profession;
    @OneToOne
    private Address address;
}
