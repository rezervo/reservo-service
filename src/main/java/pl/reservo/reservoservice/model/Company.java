package pl.reservo.reservoservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import pl.reservo.reservoservice.constants.Profession;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import java.util.Objects;


@Entity
@DiscriminatorValue("company")
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company extends ApplicationUser {

    private String name;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Profession profession;
    @OneToOne(cascade = CascadeType.ALL)
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
