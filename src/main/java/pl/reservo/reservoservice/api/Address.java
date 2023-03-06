package pl.reservo.reservoservice.api;

import javax.validation.constraints.NotBlank;

public record Address(
    @NotBlank String street,
    @NotBlank String houseNumber,
    @NotBlank String city,
    @NotBlank String zipCode) {

}
