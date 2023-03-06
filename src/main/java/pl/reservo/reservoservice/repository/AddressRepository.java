package pl.reservo.reservoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.reservo.reservoservice.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
