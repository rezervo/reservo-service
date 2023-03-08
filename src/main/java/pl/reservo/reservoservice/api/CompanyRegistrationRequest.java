package pl.reservo.reservoservice.api;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record CompanyRegistrationRequest(
    @NotBlank String firstName,
    @NotBlank String lastName,
    @NotBlank String companyName,
    @NotNull Category category,
    @NotBlank String phoneNumber,
    @Email @NotBlank String email,
    @NotNull @Valid Address address,
    @NotBlank String password) {

}
