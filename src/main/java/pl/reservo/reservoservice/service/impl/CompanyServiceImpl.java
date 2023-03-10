package pl.reservo.reservoservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.reservo.reservoservice.api.CompanyRegistrationRequest;
import pl.reservo.reservoservice.api.CompanyRegistrationResponse;
import pl.reservo.reservoservice.constants.Profession;
import pl.reservo.reservoservice.model.Address;
import pl.reservo.reservoservice.model.Company;
import pl.reservo.reservoservice.repository.CompanyRepository;
import pl.reservo.reservoservice.service.CompanyService;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {

  private final CompanyRepository companyRepository;

  @Override
  public CompanyRegistrationResponse create(final CompanyRegistrationRequest request) {
    Company company = Company.builder()
        .name(request.companyName())
        .phoneNumber(request.phoneNumber())
        .profession(request.profession())
        .email(request.email())
        .password(request.password())
        .address(Address.builder()
            .city(request.address().city())
            .street(request.address().street())
            .houseNumber(request.address().houseNumber())
            .postCode(request.address().zipCode())
            .build())
        .build();
    Company savedCompany = companyRepository.save(company);
    log.info("Saved new Company: {}", savedCompany);
    return new CompanyRegistrationResponse(savedCompany.getId());
  }
}
