package es.dws.classProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.dws.classProject.domain.entities.BookEntity;
import es.dws.classProject.enumerations.GenreEnum;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByTitleContainingIgnoreCase(String title);

    List<BookEntity> findByGenre(GenreEnum genre);

    List<BookEntity> findByTitleContainingIgnoreCaseAndGenre(String title, GenreEnum genre);

    List<BookEntity> findByLanguage(String language);

}
