package es.dws.classProject.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.dws.classProject.enumerations.GenreEnum;
import es.dws.classProject.services.BookService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BookService bookService;

    @GetMapping({ "/", "/home", "/index" })
    public String showHome(final Model model) {

        model.addAttribute("currentYear", LocalDate.now().getYear());
        model.addAttribute("books", bookService.getBooks());
        model.addAttribute("genres", GenreEnum.values());
        return "indexView";
    }

    @GetMapping({ "/info" })
    public String showInfo(final Model model) {
        model.addAttribute("currentYear", LocalDate.now().getYear());
        return "infoView";
    }
}
