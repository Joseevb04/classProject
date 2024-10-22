package es.dws.classProject.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping({ "/", "/index" })
    public String showHome(Model model) {
        model.addAttribute("currentYear", LocalDate.now().getYear());
        return "indexView";
    }

}
