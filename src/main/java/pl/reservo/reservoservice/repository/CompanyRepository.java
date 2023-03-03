package pl.reservo.reservoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.reservo.reservoservice.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
