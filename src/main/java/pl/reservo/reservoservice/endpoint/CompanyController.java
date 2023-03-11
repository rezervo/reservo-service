package pl.reservo.reservoservice.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.reservo.reservoservice.api.CompanyRegistrationRequest;
import pl.reservo.reservoservice.api.CompanyRegistrationResponse;
import pl.reservo.reservoservice.api.CompanySearchResponse;
import pl.reservo.reservoservice.constants.Profession;
import pl.reservo.reservoservice.model.Company;
import pl.reservo.reservoservice.repository.AddressRepository;
import pl.reservo.reservoservice.repository.CompanyRepository;
import pl.reservo.reservoservice.service.CompanyService;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CompanyRegistrationResponse register(@Valid @RequestBody CompanyRegistrationRequest request) {
        return companyService.create(request);
    }

    @GetMapping
    public Set<CompanySearchResponse> findByProfession(@RequestParam String service,
                                                       @RequestParam(required = false) String city) {

        return city == null ?
                companyService.findAllByProfession(service) :
                companyService.findAllByCityAndProfession(city, service);
    }

}
