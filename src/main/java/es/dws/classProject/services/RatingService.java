package es.dws.classProject.services;

import java.util.List;

import es.dws.classProject.domain.dtos.RatingDTO;

public interface RatingService {

    RatingDTO addRating(RatingDTO rating);

    List<RatingDTO> geRatingsByBookId(Long id);

    List<RatingDTO> geRatingsByUserId(Long id);

    void deleteRatingById(Long userId, Long bookId);

}
