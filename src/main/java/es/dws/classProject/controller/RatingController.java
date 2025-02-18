package es.dws.classProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.dws.classProject.domain.dtos.RatingDTO;
import es.dws.classProject.services.RatingService;
import es.dws.classProject.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final UserService userService;
    private final RatingService ratingService;

    @GetMapping("/add/{bookId}")
    public String showAddForm(@PathVariable Long bookId, Model model) {

        model.addAttribute("users", userService.getUsers());
        model.addAttribute("bookId", bookId);
        return "addRatingView";
    }

    @PostMapping("/add")
    public String addRating(@ModelAttribute RatingDTO data) {
        log.info("Adding rating: {}", data);
        ratingService.addRating(data);
        return "redirect:/book/ratings/" + data.getUserId();
    }

}
