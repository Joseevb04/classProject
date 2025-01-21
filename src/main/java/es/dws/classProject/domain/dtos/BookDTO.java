package es.dws.classProject.domain.dtos;

import java.time.LocalDate;
import java.time.Year;

import es.dws.classProject.enumerations.GenreEnum;
import es.dws.classProject.enumerations.LanguageEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
public class BookDTO {

    @NotBlank(message = "El título no puede estar vacío")
    private String title;

    @Past(message = "La fecha de lanzamiento debe ser una fecha pasada")
    @NotNull(message = "La fecha de lanzamiento no puede estar vacía")
    private Year releaseYear;

    @NotNull(message = "El género no puede estar vacío")
    private GenreEnum genre;

    @NotBlank(message = "El autor no puede estar vacío")
    private String author;

    @NotNull(message = "El idioma no puede estar vacío")
    private LanguageEnum language;

    @Size(max = 300, message = "La sinopsis debe tener un máximo de 300 caracteres")
    @NotBlank(message = "La sinopsis no puede estar vacía")
    private String synopsis;

    @Builder.Default
    private LocalDate createdAt = LocalDate.now();

}
