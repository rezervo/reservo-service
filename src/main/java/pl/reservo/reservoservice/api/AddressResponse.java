package pl.reservo.reservoservice.api;

import javax.validation.constraints.NotBlank;

public record AddressResponse(
    @NotBlank String street,
    @NotBlank String houseNumber,
    @NotBlank String city,
    @NotBlank String zipCode) {

}
