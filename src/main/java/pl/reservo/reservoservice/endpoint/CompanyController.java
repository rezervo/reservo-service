package pl.reservo.reservoservice.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.reservo.reservoservice.api.CompanyRegistrationRequest;
import pl.reservo.reservoservice.api.CompanyRegistrationResponse;
import pl.reservo.reservoservice.service.CompanyService;

import javax.validation.Valid;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
@CrossOrigin
class CompanyController {

  private final CompanyService companyService;

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public CompanyRegistrationResponse register(@Valid @RequestBody CompanyRegistrationRequest request) {
    return companyService.create(request);
  }
}
