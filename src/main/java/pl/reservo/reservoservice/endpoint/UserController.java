package pl.reservo.reservoservice.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.reservo.reservoservice.api.UserRegistrationRequest;
import pl.reservo.reservoservice.api.UserRegistrationResponse;
import pl.reservo.reservoservice.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin
class UserController {

  private final UserService userService;

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public UserRegistrationResponse register(@Valid @RequestBody UserRegistrationRequest request) {
    return userService.create(request);
  }
}
