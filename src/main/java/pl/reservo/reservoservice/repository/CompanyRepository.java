package pl.reservo.reservoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.reservo.reservoservice.api.CompanySearchResponse;
import pl.reservo.reservoservice.constants.Profession;
import pl.reservo.reservoservice.model.Company;

import java.util.Set;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {

    Set<Company> findAllByProfession(Profession profession);
    Set<Company> findAllByAddressCityAndProfession(String city, Profession profession);
}
