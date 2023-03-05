package pl.reservo.reservoservice.controller;

import pl.reservo.reservoservice.constants.UserRole;

public record CreateUserRequest(String email, String password, UserRole role, boolean isCompany) {


}
