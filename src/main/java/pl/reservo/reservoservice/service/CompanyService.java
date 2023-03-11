package pl.reservo.reservoservice.service;

import pl.reservo.reservoservice.api.CompanyRegistrationRequest;
import pl.reservo.reservoservice.api.CompanyRegistrationResponse;
import pl.reservo.reservoservice.api.CompanySearchResponse;
import pl.reservo.reservoservice.constants.Profession;
import pl.reservo.reservoservice.model.Company;

import java.util.Set;

public interface CompanyService {

  CompanyRegistrationResponse create(CompanyRegistrationRequest request);
  Set<CompanySearchResponse> findAllByProfession(String profession);
  Set<CompanySearchResponse> findAllByCityAndProfession(String city, String profession);
}
