package es.dws.classProject.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import es.dws.classProject.domain.dtos.AddBookRequestDTO;
import es.dws.classProject.domain.dtos.BookDTO;
import es.dws.classProject.domain.entities.BookEntity;

public interface BookService {

    List<BookDTO> getBooks();

    BookDTO getBookById(Long id);

    BookEntity getBookEntityById(Long id);

    BookDTO addBook(AddBookRequestDTO data, MultipartFile image);

    BookDTO updateBookById(Long id, AddBookRequestDTO data);

    void deleteBookById(Long id);

    List<BookDTO> getBooksByTitleMatching(String title);

    List<BookDTO> getBooksByGenre(String genre);

    List<BookDTO> getBooksByTitleAndGenre(String title, String genre);

    List<BookDTO> getBooksByLanguage(String language);

}
