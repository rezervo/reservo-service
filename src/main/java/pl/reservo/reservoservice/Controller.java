package pl.reservo.reservoservice;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.reservo.reservoservice.model.Customer;
import pl.reservo.reservoservice.repository.CustomerRepository;

@RestController
@AllArgsConstructor
public class Controller {

    private final CustomerRepository customerRepository;

    @GetMapping
    private void test() {

        Customer customer = Customer.builder()
                .lastName("test")
                .build();

        customerRepository.save(customer);

    }
}
