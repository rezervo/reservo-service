package pl.reservo.reservoservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.reservo.reservoservice.constants.UserRole;
import pl.reservo.reservoservice.model.ApplicationUser;
import pl.reservo.reservoservice.model.Company;
import pl.reservo.reservoservice.model.Customer;
import pl.reservo.reservoservice.model.Reservation;
import pl.reservo.reservoservice.repository.ApplicationUserRepository;
import pl.reservo.reservoservice.repository.CompanyRepository;
import pl.reservo.reservoservice.repository.CustomerRepository;
import pl.reservo.reservoservice.repository.ReservationRepository;
import pl.reservo.reservoservice.security.TokenService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    //TODO It is example class, implement it with business requirements and separated controllers

    private final TokenService tokenService;
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;
    private final ApplicationUserRepository userRepository;
    private final ReservationRepository reservationRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/me")
    public String sayHello(Principal principal) {
        val user = userRepository.findByEmail(principal.getName()).get();
        if(user.getUserRole().equals(UserRole.ROLE_COMPANY)) {
            return "Hello" + companyRepository.findById(user.getId());
        } else if(user.getUserRole().equals(UserRole.ROLE_CUSTOMER)) {
            return "Hello" + userRepository.findById(user.getId());
        }

        return "Hello " + principal.getName();
    }

    @PostMapping("/login")
    public String token(Authentication authentication) {
        log.debug("Token requested for user: '{}'", authentication.getName());
        String token = tokenService.generateToken(authentication);
        log.debug("Token granted: {}", token);
        return token;
    }

    @PostMapping("/register")
    @Transactional
    public String register(@RequestBody CreateUserRequest request) {
        log.info("Processing new user register request {}", request);
        if (request.isCompany()) {
            val company = Company.builder()
                    .name("test company")
                    .build();
            company.setEmail(request.email());
            company.setPassword(passwordEncoder.encode(request.password()));
            company.setUserRole(request.role());
            companyRepository.save(company);
        } else {
            val customer = Customer.builder()
                    .firstName("test customer")
                    .build();
            customer.setEmail(request.email());
            customer.setPassword(passwordEncoder.encode(request.password()));
            customer.setUserRole(UserRole.ROLE_CUSTOMER);
            customerRepository.save(customer);
        }
        return "registered";
    }
}
