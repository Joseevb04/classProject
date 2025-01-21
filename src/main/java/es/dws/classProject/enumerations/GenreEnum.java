package es.dws.classProject.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GenreEnum {
    ACTION("Acción"),
    COMEDY("Comedia"),
    DRAMA("Drama"),
    ADVENTURE("Aventura"),
    SCI_FI("Ciencia ficción"),
    HORROR("Terror"),
    FANTASY("Fantasía"),
    THRILLER("Thriller"),
    ROMANCE("Romance"),
    MYSTERY("Misterio"),
    CRIME("Crimen"),
    SUSPENSE("Suspenso");

    private final String name;
}
