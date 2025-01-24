package es.dws.classProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.dws.classProject.domain.entities.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByTitleContainingIgnoreCase(String title);

    List<BookEntity> findByGenreIgnoreCase(String genre);

    List<BookEntity> findByTitleContainingAndGenreIgnoreCase(String title, String genre);

    List<BookEntity> findByLanguageIgnoreCase(String language);

}
