package es.dws.classProject.services;

import java.util.List;

import es.dws.classProject.domain.dtos.RatingDTO;

public interface RatingService {

    RatingDTO addRating(RatingDTO rating);

    List<RatingDTO> getRatingsByBookId(Long id);

    List<RatingDTO> getRatingsByUserId(Long id);

    void deleteRatingById(Long userId, Long bookId);

}
