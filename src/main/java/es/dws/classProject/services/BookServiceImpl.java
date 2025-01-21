package es.dws.classProject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.dws.classProject.domain.dtos.BookDTO;
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
    public BookDTO addBook(BookDTO bookDTO) {

        log.info("Adding book: {}", bookDTO.toString());

        return bookMapper.toDTO(bookRepository.save(bookMapper.toEntity(bookDTO)));
    }

    @Override
    public BookDTO updateBookById(Long id, BookDTO data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBookById'");
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDTO> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre)
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
