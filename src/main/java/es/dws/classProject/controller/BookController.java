package es.dws.classProject.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.dws.classProject.domain.dtos.BookDTO;
import es.dws.classProject.enumerations.GenreEnum;
import es.dws.classProject.enumerations.LanguageEnum;
import es.dws.classProject.services.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/add")
    public String showAddBookForm(final Model model) {

        model.addAttribute("genres", GenreEnum.values());
        model.addAttribute("languages", LanguageEnum.values());

        return "addBookView";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute final BookDTO bookDTO) {
        if (bookDTO.getCreatedAt() == null) {
            bookDTO.setCreatedAt(LocalDate.now());
        }

        log.info("Initializing the book saving process - Controller Layer: {}", bookDTO.toString());

        bookService.addBook(bookDTO);
        return "redirect:/?success=1";
    }

}
