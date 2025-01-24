package es.dws.classProject.domain.dtos;

import es.dws.classProject.enumerations.GenreEnum;
import es.dws.classProject.enumerations.LanguageEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddBookRequestDTO {

    @NotBlank(message = "El título no puede estar vacío")
    private String title;

    @NotNull(message = "La fecha de lanzamiento no puede estar vacía")
    private Integer releaseYear;

    @NotNull(message = "El género no puede estar vacío")
    private GenreEnum genre;

    @NotBlank(message = "El autor no puede estar vacío")
    private String author;

    @NotNull(message = "El idioma no puede estar vacío")
    private LanguageEnum language;

    @Size(max = 300, message = "La sinopsis debe tener un máximo de 300 caracteres")
    @NotBlank(message = "La sinopsis no puede estar vacía")
    private String synopsis;

}
