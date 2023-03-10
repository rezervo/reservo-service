package pl.reservo.reservoservice.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Profession {

    BARBER("Fryzjer"),
    MECHANIC("Mechanik"),
    TUTOR("Korepetycje");

    private final String translation;
}
