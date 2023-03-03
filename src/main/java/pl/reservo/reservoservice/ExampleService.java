package pl.reservo.reservoservice;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.reservo.reservoservice.constants.UserRole;
import pl.reservo.reservoservice.model.ApplicationUser;
import pl.reservo.reservoservice.model.Company;
import pl.reservo.reservoservice.model.Customer;
import pl.reservo.reservoservice.model.Reservation;
import pl.reservo.reservoservice.repository.ApplicationUserRepository;
import pl.reservo.reservoservice.repository.CompanyRepository;
import pl.reservo.reservoservice.repository.CustomerRepository;
import pl.reservo.reservoservice.repository.ReservationRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ExampleService {


    private ApplicationUserRepository applicationUserRepository;
    private CustomerRepository customerRepository;
    private CompanyRepository companyRepository;
    private ReservationRepository reservationRepository;

    public void  test(){
        //create user
        ApplicationUser userCompany = ApplicationUser.builder()
                .email("aaa@a.pl")
                .password("aaa")
                .userRole(UserRole.ROLE_USER)
                .build();
        Company company = Company.builder()
                .user(userCompany)
                .name("test")
                .phoneNumber("test phone")
                .build();
        companyRepository.save(company);

        Customer customer = Customer.builder()
                .firstName("test name")
                .phoneNumber("test phone customer")
                .user(userCompany)
                .build();
        customerRepository.save(customer);

        System.out.println("Customer: " + customerRepository.getReferenceById(1L));
        System.out.println("Company: " + companyRepository.getReferenceById(1L));

        Reservation reservation = Reservation.builder()
                .starTime(LocalDateTime.now())
                .endTime(LocalDateTime.now().plusHours(1))
                .isAvailable(true)
                .build();
        reservationRepository.save(reservation);

        Reservation reservationAvailable = reservationRepository.getReferenceById(1L);
        System.out.println(reservationAvailable);
        reservationAvailable.setCustomer(customer);
        reservationAvailable.setCompany(company);

        reservationRepository.save(reservationAvailable);

        System.out.println("After reservation: "+ reservationAvailable);
        System.out.println("After company: "+ company);
        System.out.println("After customer "+ customer);

        System.out.println(companyRepository.getReferenceById(1L));

    }
}
