package pl.reservo.reservoservice.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.reservo.reservoservice.service.ProfessionService;

import java.util.Map;

@RestController
@RequestMapping("/professions")
@RequiredArgsConstructor
class ProfessionController {

  private final ProfessionService professionService;

  @GetMapping
  public Map<String, String> getAvailableProfessions() {
    return professionService.getAvailableProfessions();
  }
}
