package es.dws.classProject.services;

import java.util.List;

import es.dws.classProject.domain.dtos.BookDTO;

public interface BookService {

    List<BookDTO> getBooks();

    BookDTO getBookById(Long id);

    BookDTO addBook(BookDTO bookDTO);

    BookDTO updateBookById(Long id, BookDTO data);

    void deleteBookById(Long id);

    List<BookDTO> getBooksByGenre(String genre);

    List<BookDTO> getBooksByLanguage(String language);

}
