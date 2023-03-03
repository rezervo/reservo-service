package pl.reservo.reservoservice.service;

import pl.reservo.reservoservice.api.UserRegistrationRequest;
import pl.reservo.reservoservice.api.UserRegistrationResponse;

public interface UserService {

  UserRegistrationResponse create(UserRegistrationRequest request);
}
