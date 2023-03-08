package pl.reservo.reservoservice.service;

import pl.reservo.reservoservice.api.CompanyRegistrationRequest;
import pl.reservo.reservoservice.api.CompanyRegistrationResponse;

public interface CompanyService {

  CompanyRegistrationResponse create(CompanyRegistrationRequest request);
}
