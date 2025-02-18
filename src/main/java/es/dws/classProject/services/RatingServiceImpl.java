package es.dws.classProject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.dws.classProject.domain.dtos.RatingDTO;
import es.dws.classProject.domain.entities.RatingEntity;
import es.dws.classProject.domain.entities.keys.RatingEntityKey;
import es.dws.classProject.mappers.RatingMapper;
import es.dws.classProject.repositories.RatingRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final BookService bookService;
    private final UserService userService;
    private final RatingMapper ratingMapper;
    private final RatingRepository ratingRepository;

    @Override
    public RatingDTO addRating(RatingDTO rating) {
        final var user = userService.getUserEntityById(rating.getUserId());
        final var book = bookService.getBookEntityById(rating.getBookId());

        final var key = new RatingEntityKey(user.getId(), book.getId());

        final RatingEntity ratingEntity = ratingMapper.toEntity(rating);
        ratingEntity.setUser(user);
        ratingEntity.setBook(book);
        ratingEntity.setKey(key);

        return ratingMapper.toDTO(ratingRepository.save(ratingEntity));

    }

    @Override
    public List<RatingDTO> getRatingsByBookId(Long id) {
        return ratingRepository.findAllByBookId(id)
                .stream()
                .map(ratingMapper::toDTO)
                .toList();
    }

    @Override
    public List<RatingDTO> getRatingsByUserId(Long id) {
        return ratingRepository.findAllByUserId(id)
                .stream()
                .map(ratingMapper::toDTO)
                .toList();
    }

    @Override
    public void deleteRatingById(Long userId, Long bookId) {
        final var key = new RatingEntityKey(
                userService.getUserById(userId).getId(),
                bookService.getBookById(bookId).getId());
        ratingRepository.deleteById(key);
    }

}
