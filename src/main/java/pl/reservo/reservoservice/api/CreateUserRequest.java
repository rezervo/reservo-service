package pl.reservo.reservoservice.api;

import lombok.Builder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Builder
public class CreateUserRequest {

  @NotBlank
  private final String firstName;
  @NotBlank
  private final String lastName;
  @NotBlank
  private final String phoneNumber;
  @Email
  @NotBlank
  private final String email;
  @NotBlank
  private final String password;
}
