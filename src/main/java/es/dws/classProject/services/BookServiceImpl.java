package es.dws.classProject.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import es.dws.classProject.domain.dtos.AddBookRequestDTO;
import es.dws.classProject.domain.dtos.BookDTO;
import es.dws.classProject.domain.entities.BookEntity;
import es.dws.classProject.enumerations.GenreEnum;
import es.dws.classProject.mappers.BookMapper;
import es.dws.classProject.repositories.BookRepository;
import es.dws.classProject.repositories.GenreRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final FileStorageService fileStorageService;
    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookDTO> getBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDTO)
                .toList();
    }

    @Override
    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Could not find Book by the ID: %d".formatted(id)));
    }

    @Override
    public BookDTO addBook(AddBookRequestDTO data, MultipartFile image) {

        log.info("Adding book: {}", data.toString());

        final BookEntity entity = bookMapper.toEntity(data);
        entity.setCreatedAt(LocalDate.now());

        entity.setGenre(genreRepository.findById(data.getGenre()).orElseThrow(
                () -> new EntityNotFoundException("Could not find Genre by the ID: %d".formatted(data.getGenre()))));

        String newFileName = fileStorageService.store(image);

        entity.setImageUrl(newFileName);

        return bookMapper.toDTO(bookRepository.save(entity));
    }

    @Override
    public BookDTO updateBookById(Long id, AddBookRequestDTO data) {
        return bookMapper.toDTO(bookRepository.findById(id)
                .map(previousBook -> {

                    bookMapper.updateBookFromDTO(data, previousBook);
                    return bookRepository.save(previousBook);
                })
                .orElseThrow(() -> new EntityNotFoundException("Could not find Book by the ID: %d".formatted(id))));
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDTO> getBooksByTitleMatching(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(bookMapper::toDTO)
                .toList();
    }

    @Override
    public List<BookDTO> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(GenreEnum.valueOf(genre))
                .stream()
                .map(bookMapper::toDTO)
                .toList();
    }

    @Override
    public List<BookDTO> getBooksByTitleAndGenre(String title, String genre) {
        return bookRepository.findByTitleContainingIgnoreCaseAndGenre(title, GenreEnum.valueOf(genre))
                .stream()
                .map(bookMapper::toDTO)
                .toList();
    }

    @Override
    public List<BookDTO> getBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language)
                .stream()
                .map(bookMapper::toDTO)
                .toList();
    }

}
