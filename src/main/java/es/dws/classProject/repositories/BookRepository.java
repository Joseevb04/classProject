package es.dws.classProject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.dws.classProject.domain.entities.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    Optional<BookEntity> findByGenre(String genre);

    Optional<BookEntity> findByLanguage(String language);

}
