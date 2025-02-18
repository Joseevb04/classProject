package es.dws.classProject.config;

import es.dws.classProject.domain.entities.BookEntity;
import es.dws.classProject.domain.entities.GenreEntity;
import es.dws.classProject.domain.entities.RatingEntity;
import es.dws.classProject.domain.entities.UserEntity;
import es.dws.classProject.domain.entities.keys.RatingEntityKey;
import es.dws.classProject.enumerations.GenreEnum;
import es.dws.classProject.enumerations.LanguageEnum;
import es.dws.classProject.repositories.BookRepository;
import es.dws.classProject.repositories.GenreRepository;
import es.dws.classProject.repositories.RatingRepository;
import es.dws.classProject.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenreDataInitializer implements CommandLineRunner {

    private final GenreRepository genreRepository;
    private final UserRepository userRepository;
    private final RatingRepository ratingRepository;
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        if (genreRepository.count() < GenreEnum.values().length) {
            Stream.of(GenreEnum.values())
                    .filter(g -> !genreRepository.existsById(g))
                    .map(g -> GenreEntity.builder().genre(g).build())
                    .forEach(genreRepository::save);
        }

        if (bookRepository.count() == 0) {
            GenreEntity adventure = genreRepository.findById(GenreEnum.ADVENTURE)
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Could not find genre by the ID: %d".formatted(GenreEnum.ADVENTURE)));
            GenreEntity sciFi = genreRepository.findById(GenreEnum.SCI_FI)
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Could not find genre by the ID: %d".formatted(GenreEnum.SCI_FI)));
            GenreEntity fantasy = genreRepository.findById(GenreEnum.FANTASY)
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Could not find genre by the ID: %d".formatted(GenreEnum.FANTASY)));
            GenreEntity drama = genreRepository.findById(GenreEnum.DRAMA).orElseThrow(
                    () -> new EntityNotFoundException("Could not find genre by the ID: %d".formatted(GenreEnum.DRAMA)));
            GenreEntity horror = genreRepository.findById(GenreEnum.HORROR)
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Could not find genre by the ID: %d".formatted(GenreEnum.HORROR)));
            GenreEntity romance = genreRepository.findById(GenreEnum.ROMANCE)
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Could not find genre by the ID: %d".formatted(GenreEnum.ROMANCE)));
            GenreEntity mystery = genreRepository.findById(GenreEnum.MYSTERY)
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Could not find genre by the ID: %d".formatted(GenreEnum.MYSTERY)));
            GenreEntity crime = genreRepository.findById(GenreEnum.CRIME).orElseThrow(
                    () -> new EntityNotFoundException("Could not find genre by the ID: %d".formatted(GenreEnum.CRIME)));
            GenreEntity thriller = genreRepository.findById(GenreEnum.THRILLER)
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Could not find genre by the ID: %d".formatted(GenreEnum.THRILLER)));

            // Add books using the builder pattern
            bookRepository.saveAll(List.of(
                    BookEntity.builder()
                            .title("El Quijote")
                            .releaseYear(1605)
                            .genre(adventure)
                            .author("Miguel de Cervantes")
                            .language(LanguageEnum.ES) // Assuming you have an enum for language
                            .synopsis("Un caballero y su escudero en aventuras épicas.")
                            .createdAt(LocalDate.parse("2025-01-01"))
                            .build(),

                    BookEntity.builder()
                            .title("1984")
                            .releaseYear(1949)
                            .genre(sciFi)
                            .author("George Orwell")
                            .language(LanguageEnum.EN) // Assuming you have an enum for language
                            .synopsis("Una distopía sobre el control y la vigilancia.")
                            .createdAt(LocalDate.parse("2025-01-01"))
                            .build(),

                    BookEntity.builder()
                            .title("Os Lusiadas")
                            .releaseYear(1572)
                            .genre(fantasy)
                            .author("Luís de Camões")
                            .language(LanguageEnum.PT) // Assuming you have an enum for language
                            .synopsis("Una epopeya sobre los exploradores portugueses.")
                            .createdAt(LocalDate.parse("2025-01-01"))
                            .build(),

                    BookEntity.builder()
                            .title("Don Juan Tenorio")
                            .releaseYear(1844)
                            .genre(drama)
                            .author("José Zorrilla")
                            .language(LanguageEnum.ES) // Assuming you have an enum for language
                            .synopsis("Un drama romántico clásico español.")
                            .createdAt(LocalDate.parse("2025-01-01"))
                            .build(),

                    BookEntity.builder()
                            .title("O Apóstolo")
                            .releaseYear(2012)
                            .genre(horror)
                            .author("Fernando Cortizo")
                            .language(LanguageEnum.GA) // Assuming you have an enum for language
                            .synopsis("Un thriller sobrenatural en Galicia.")
                            .createdAt(LocalDate.parse("2025-01-01"))
                            .build(),

                    BookEntity.builder()
                            .title("Pride and Prejudice")
                            .releaseYear(1813)
                            .genre(romance)
                            .author("Jane Austen")
                            .language(LanguageEnum.EN) // Assuming you have an enum for language
                            .synopsis("Una historia de amor y malentendidos en la Inglaterra del siglo XIX.")
                            .createdAt(LocalDate.parse("2025-01-01"))
                            .build(),

                    BookEntity.builder()
                            .title("The Murder of Roger Ackroyd")
                            .releaseYear(1926)
                            .genre(mystery)
                            .author("Agatha Christie")
                            .language(LanguageEnum.EN) // Assuming you have an enum for language
                            .synopsis("Un caso intrigante resuelto por Hercule Poirot.")
                            .createdAt(LocalDate.parse("2025-01-01"))
                            .build(),

                    BookEntity.builder()
                            .title("Los Crímenes de la Calle Morgue")
                            .releaseYear(1841)
                            .genre(crime)
                            .author("Edgar Allan Poe")
                            .language(LanguageEnum.ES) // Assuming you have an enum for language
                            .synopsis("El primer misterio de asesinato moderno.")
                            .createdAt(LocalDate.parse("2025-01-01"))
                            .build(),

                    BookEntity.builder()
                            .title("La Sombra del Viento")
                            .releaseYear(2001)
                            .genre(thriller)
                            .author("Carlos Ruiz Zafón")
                            .language(LanguageEnum.ES) // Assuming you have an enum for language
                            .synopsis("Un thriller literario ambientado en Barcelona.")
                            .createdAt(LocalDate.parse("2025-01-01"))
                            .build(),

                    BookEntity.builder()
                            .title("Dune")
                            .releaseYear(1965)
                            .genre(sciFi)
                            .author("Frank Herbert")
                            .language(LanguageEnum.EN) // Assuming you have an enum for language
                            .synopsis("Una obra maestra de la ciencia ficción sobre política y ecología.")
                            .createdAt(LocalDate.parse("2025-01-01"))
                            .build()));
        }

        if (userRepository.count() == 0) {
            List<UserEntity> users = List.of(
                    UserEntity.builder().username("user1").password("password1").build(),
                    UserEntity.builder().username("user2").password("password2").build(),
                    UserEntity.builder().username("user3").password("password3").build(),
                    UserEntity.builder().username("user4").password("password4").build(),
                    UserEntity.builder().username("user5").password("password5").build());
            userRepository.saveAll(users);
        }

        if (ratingRepository.count() == 0) {
            final List<RatingEntity> ratings = List.of(
                    new RatingEntity(new RatingEntityKey(1L, 1L),
                            userRepository.findById(1L).orElse(null),
                            bookRepository.findById(1L)
                                    .orElseThrow(() -> new EntityNotFoundException("Book not found with id 1")),
                            5,
                            "Una obra maestra de la literatura española."),
                    new RatingEntity(new RatingEntityKey(2L, 2L),
                            userRepository.findById(2L).orElse(null),
                            bookRepository.findById(2L)
                                    .orElseThrow(() -> new EntityNotFoundException("Book not found with id 2")),
                            4,
                            "Un libro visionario y perturbador."),
                    new RatingEntity(new RatingEntityKey(3L, 3L),
                            userRepository.findById(3L).orElse(null),
                            bookRepository.findById(3L)
                                    .orElseThrow(() -> new EntityNotFoundException("Book not found with id 3")),
                            5,
                            "Un clásico de la poesía épica."),
                    new RatingEntity(new RatingEntityKey(4L, 4L),
                            userRepository.findById(4L).orElse(null),
                            bookRepository.findById(4L)
                                    .orElseThrow(() -> new EntityNotFoundException("Book not found with id 4")),
                            3,
                            "Interesante, pero un poco anticuado."),
                    new RatingEntity(new RatingEntityKey(5L, 5L),
                            userRepository.findById(5L).orElse(null),
                            bookRepository.findById(5L)
                                    .orElseThrow(() -> new EntityNotFoundException("Book not found with id 5")),
                            4,
                            "Me encantó el ambiente oscuro."));
            ratingRepository.saveAll(ratings);
        }
    }
}
