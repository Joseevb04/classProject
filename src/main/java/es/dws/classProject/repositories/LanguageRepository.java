package es.dws.classProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.dws.classProject.domain.entities.LanguageEntity;
import es.dws.classProject.enumerations.LanguageEnum;

public interface LanguageRepository extends JpaRepository<LanguageEntity, LanguageEnum> {

}
