package pl.reservo.reservoservice.api;

import lombok.Builder;

import javax.validation.constraints.NotBlank;

@Builder
public class Address {

  @NotBlank
  private final String street;
  @NotBlank
  private final String houseNumber;
  @NotBlank
  private final String city;
  @NotBlank
  private final String zipCode;
}
