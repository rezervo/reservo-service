package pl.reservo.reservoservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.reservo.reservoservice.api.UserRegistrationRequest;
import pl.reservo.reservoservice.api.UserRegistrationResponse;
import pl.reservo.reservoservice.model.Customer;
import pl.reservo.reservoservice.repository.CustomerRepository;
import pl.reservo.reservoservice.service.UserService;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

  private final CustomerRepository customerRepository;

  @Override
  public UserRegistrationResponse create(final UserRegistrationRequest request) {
    Customer customer = Customer.builder()
        .email(request.email())
        .password(request.password())
        .firstName(request.firstName())
        .lastName(request.lastName())
        .phoneNumber(request.phoneNumber())
        .build();
    Customer savedCustomer = customerRepository.save(customer);
    log.info("Saved new Customer: {}", savedCustomer);
    return new UserRegistrationResponse(savedCustomer.getId());
  }
}
