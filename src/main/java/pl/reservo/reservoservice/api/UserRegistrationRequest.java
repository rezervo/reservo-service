package pl.reservo.reservoservice.api;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record UserRegistrationRequest(
    @NotBlank String firstName,
    @NotBlank String lastName,
    @NotBlank String phoneNumber,
    @Email @NotBlank String email,
    @NotBlank String password) {

}
