package es.dws.classProject.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LanguageEnum {
    ES("Español", "es"),
    EN("Inglés", "en"),
    GA("Gallego", "ga"),
    PT("Portugués", "pt");

    private final String name;
    private final String code;
}
