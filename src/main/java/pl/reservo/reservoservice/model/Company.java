package pl.reservo.reservoservice.model;

import jakarta.persistence.*;
import lombok.*;
import pl.reservo.reservoservice.constants.Profession;

import java.util.Objects;


@Entity
@DiscriminatorValue("company")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company extends ApplicationUser {

    private String name;
    private String phoneNumber;
    private Profession profession;
    @OneToOne
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) && Objects.equals(phoneNumber, company.phoneNumber) && profession == company.profession && Objects.equals(address, company.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, phoneNumber, profession, address);
    }
}
