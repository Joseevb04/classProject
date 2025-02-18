package es.dws.classProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.dws.classProject.domain.entities.RatingEntity;
import es.dws.classProject.domain.entities.keys.RatingEntityKey;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, RatingEntityKey> {

    List<RatingEntity> findAllByUserId(Long userId);

    List<RatingEntity> findAllByBookId(Long bookId);

}
