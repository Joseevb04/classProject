package es.dws.classProject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.dws.classProject.domain.dtos.RatingDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final BookService bookService;

    @Override
    public RatingDTO addRating(RatingDTO rating) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addRating'");
    }

    @Override
    public List<RatingDTO> geRatingsByBookId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'geRatingsByBookId'");
    }

    @Override
    public List<RatingDTO> geRatingsByUserId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'geRatingsByUserId'");
    }

    @Override
    public void deleteRatingById(Long userId, Long bookId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRatingById'");
    }

}
