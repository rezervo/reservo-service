package pl.reservo.reservoservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;


@Entity
@DiscriminatorValue("candidate")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends ApplicationUser {

    private String firstName;
    private String lastName;
    private String phoneNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(phoneNumber, customer.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, phoneNumber);
    }
}
