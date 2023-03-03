package pl.reservo.reservoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.reservo.reservoservice.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, String> {
}
