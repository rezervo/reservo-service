package pl.reservo.reservoservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.reservo.reservoservice.repository.ApplicationUserRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        val userFromDb = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(String.format("User with email %s not found", email)));
        if (userFromDb.isEnabled()) {
            val authorities = Set.of(new SimpleGrantedAuthority(userFromDb.getUserRole().name()));
            return new User(email, userFromDb.getPassword(), authorities);
        }
        throw new RuntimeException(String.format("User with email %s is disabled", email));
    }
}
