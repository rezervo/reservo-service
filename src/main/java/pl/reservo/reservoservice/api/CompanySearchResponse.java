package pl.reservo.reservoservice.api;

import java.util.UUID;

public record CompanySearchResponse(UUID id, String name, String profession, AddressResponse address) {
}
