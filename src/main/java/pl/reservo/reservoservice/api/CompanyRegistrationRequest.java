package pl.reservo.reservoservice.api;

import lombok.Builder;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
public class CompanyRegistrationRequest {

  @NotBlank
  private final String firstName;
  @NotBlank
  private final String lastName;
  @NotBlank
  private final String companyName;
  @NotNull
  private final Category category;
  @NotBlank
  private final String phoneNumber;
  @Email
  @NotBlank
  private final String email;
  @NotNull
  @Valid
  private final Address address;
  @NotBlank
  private final String password;
}
