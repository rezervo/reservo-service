package pl.reservo.reservoservice.service.impl;

import org.springframework.stereotype.Service;
import pl.reservo.reservoservice.constants.Profession;
import pl.reservo.reservoservice.service.ProfessionService;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProfessionServiceImpl implements ProfessionService {

  @Override
  public Map<String, String> getAvailableProfessions() {
    return Arrays.stream(Profession.values())
        .collect(Collectors.toMap(Profession::name, Profession::getTranslation));
  }
}
