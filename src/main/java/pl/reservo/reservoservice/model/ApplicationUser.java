package pl.reservo.reservoservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.reservo.reservoservice.constants.UserRole;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUser  {
//TODO implement UserDetails from Spring Security

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

}
