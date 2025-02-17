package es.dws.classProject.repositories;

import es.dws.classProject.domain.entities.GenreEntity;
import es.dws.classProject.enumerations.GenreEnum;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<GenreEntity, GenreEnum> {
}
