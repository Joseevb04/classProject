package es.dws.classProject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.dws.classProject.domain.entities.RatingEntity;
import es.dws.classProject.domain.entities.keys.RatingEntityKey;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, RatingEntityKey> {

    Optional<RatingEntity> findByUserId(Long userId);

    Optional<RatingEntity> findByBookId(Long bookId);

}
