package pl.reservo.reservoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.reservo.reservoservice.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
