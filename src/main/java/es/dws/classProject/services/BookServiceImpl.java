package es.dws.classProject.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import es.dws.classProject.domain.dtos.AddBookRequestDTO;
import es.dws.classProject.domain.dtos.BookDTO;
import es.dws.classProject.domain.entities.BookEntity;
import es.dws.classProject.mappers.BookMapper;
import es.dws.classProject.repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

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
    public BookDTO addBook(AddBookRequestDTO data) {

        log.info("Adding book: {}", data.toString());

        final BookEntity entity = bookMapper.toEntity(data);
        entity.setCreatedAt(LocalDate.now());

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
        return bookRepository.findByGenreIgnoreCase(genre)
                .stream()
                .map(bookMapper::toDTO)
                .toList();
    }

    @Override
    public List<BookDTO> getBooksByTitleAndGenre(String title, String genre) {
        return bookRepository.findByTitleContainingAndGenreIgnoreCase(title, genre)
                .stream()
                .map(bookMapper::toDTO)
                .toList();
    }

    @Override
    public List<BookDTO> getBooksByLanguage(String language) {
        return bookRepository.findByLanguageIgnoreCase(language)
                .stream()
                .map(bookMapper::toDTO)
                .toList();
    }

}
