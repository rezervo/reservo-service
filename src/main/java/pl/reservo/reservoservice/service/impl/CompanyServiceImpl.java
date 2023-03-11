package pl.reservo.reservoservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.reservo.reservoservice.api.AddressResponse;
import pl.reservo.reservoservice.api.CompanyRegistrationRequest;
import pl.reservo.reservoservice.api.CompanyRegistrationResponse;
import pl.reservo.reservoservice.api.CompanySearchResponse;
import pl.reservo.reservoservice.constants.Profession;
import pl.reservo.reservoservice.model.Address;
import pl.reservo.reservoservice.model.Company;
import pl.reservo.reservoservice.repository.CompanyRepository;
import pl.reservo.reservoservice.service.CompanyService;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public Set<CompanySearchResponse> findAllByProfession(String service) {
        Profession professionToFind = Arrays.stream(Profession.values())
                .filter(profession -> profession.name().equals(service.toUpperCase()))
                .findAny()
                .orElse(null);
        return companyRepository.findAllByProfession(professionToFind).stream()
                .map(company -> new CompanySearchResponse(
                        company.getId(),
                        company.getName(),
                        company.getProfession().name(),
                        new AddressResponse(
                                company.getAddress().getStreet(),
                                company.getAddress().getHouseNumber(),
                                company.getAddress().getCity(),
                                company.getAddress().getPostCode())))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<CompanySearchResponse> findAllByCityAndProfession(String city, String service) {
        Profession professionToFind = Arrays.stream(Profession.values())
                .filter(profession -> profession.name().equals(service.toUpperCase()))
                .findAny()
                .orElse(null);
        return companyRepository.findAllByAddressCityAndProfession(city, professionToFind).stream()
                .map(company -> new CompanySearchResponse(
                        company.getId(),
                        company.getName(),
                        company.getProfession().name(),
                        new AddressResponse(
                                company.getAddress().getStreet(),
                                company.getAddress().getHouseNumber(),
                                company.getAddress().getCity(),
                                company.getAddress().getPostCode())))
                .collect(Collectors.toSet());
    }

}
