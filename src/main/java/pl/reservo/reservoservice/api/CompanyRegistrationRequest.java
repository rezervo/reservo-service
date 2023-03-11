package pl.reservo.reservoservice.api;

import pl.reservo.reservoservice.constants.Profession;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record CompanyRegistrationRequest(
    @NotBlank String firstName,
    @NotBlank String lastName,
    @NotBlank String companyName,
    @NotNull Profession profession,
    @NotBlank String phoneNumber,
    @Email @NotBlank String email,
    @NotNull @Valid AddressResponse address,
    @NotBlank String password) {

}
