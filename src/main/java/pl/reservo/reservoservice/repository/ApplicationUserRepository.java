package pl.reservo.reservoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.reservo.reservoservice.model.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, String> {

    Optional<ApplicationUser> findByEmail(String email);
    boolean existsByEmail(String email);
}
