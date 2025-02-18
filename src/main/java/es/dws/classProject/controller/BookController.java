package es.dws.classProject.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import es.dws.classProject.domain.dtos.AddBookRequestDTO;
import es.dws.classProject.domain.dtos.BookDTO;
import es.dws.classProject.enumerations.GenreEnum;
import es.dws.classProject.enumerations.LanguageEnum;
import es.dws.classProject.services.BookService;
import es.dws.classProject.services.RatingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final RatingService ratingService;
    private final BookService bookService;

    @GetMapping("/{id}")
    public String showBookById(final Model model, @PathVariable Long id) {

        final BookDTO book = bookService.getBookById(id);

        model.addAttribute("book", book);
        model.addAttribute("currentYear", LocalDate.now().getYear());

        return "bookView";
    }

    @GetMapping("/add")
    public String showAddBookForm(final Model model) {

        model.addAttribute("genres", GenreEnum.values());
        model.addAttribute("languages", LanguageEnum.values());
        model.addAttribute("currentYear", LocalDate.now().getYear());

        return "addBookView";
    }

    @GetMapping("/search")
    public String showSearchBookForm(
            @RequestParam(name = "title") final Optional<String> title,
            @RequestParam(name = "genre") final Optional<String> genre,
            final Model model) {

        final Optional<GenreEnum> genreEnum = genre.flatMap(g -> {
            try {
                return Optional.of(GenreEnum.valueOf(g.toUpperCase()));
            } catch (IllegalArgumentException e) {
                return Optional.empty();
            }
        });

        final List<BookDTO> books = title
                .map(t -> genreEnum
                        .map(g -> bookService.getBooksByTitleMatching(t).stream()
                                .filter(book -> book.getGenre() == g)
                                .toList())
                        .orElseGet(() -> bookService.getBooksByTitleMatching(t)))
                .orElseGet(() -> genreEnum
                        .map(g -> bookService.getBooksByGenre(g.name()))
                        .orElseGet(() -> bookService.getBooks()));

        books.forEach(book -> log.info("Book: {}", book.toString()));

        model.addAttribute("books", books);
        model.addAttribute("genres", GenreEnum.values());
        model.addAttribute("currentYear", LocalDate.now().getYear());

        return "indexView";
    }

    @GetMapping("/edit/{id}")
    public String showEditBookForm(final Model model, @PathVariable Long id) {

        final BookDTO book = bookService.getBookById(id);

        model.addAttribute("book", book);
        model.addAttribute("genres", GenreEnum.values());
        model.addAttribute("languages", LanguageEnum.values());
        model.addAttribute("currentYear", LocalDate.now().getYear());

        return "editBookView";
    }

    @GetMapping("/delete/{id}")
    public String deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return "redirect:/";
    }

    @GetMapping("/ratings/{id}")
    public String showRatings(@PathVariable final Long id, final Model model) {

        model.addAttribute("ratings", ratingService.getRatingsByBookId(id));
        model.addAttribute("book", bookService.getBookById(id));
        model.addAttribute("currentYear", LocalDate.now().getYear());

        return "ratingsView";
    }

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addBook(
            @ModelAttribute final AddBookRequestDTO data,
            @RequestParam("image") MultipartFile image) {

        log.info("Initializing the book saving process - Controller Layer: {}", data.toString());

        bookService.addBook(data, image);
        return "redirect:/?success=1";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@ModelAttribute final AddBookRequestDTO data, @PathVariable Long id) {

        bookService.updateBookById(id, data);
        return "redirect:/?success=1";
    }

}
