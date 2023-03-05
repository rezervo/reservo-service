package pl.reservo.reservoservice.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@DiscriminatorValue("candidate")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends ApplicationUser {

    private String firstName;
    private String lastName;
    private String phoneNumber;

}
