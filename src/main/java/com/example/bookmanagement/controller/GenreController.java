package com.example.bookmanagement.controller;

import com.example.bookmanagement.model.Genre;
import com.example.bookmanagement.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public String listGenres(Model model) {
        model.addAttribute("genres", genreService.findAll());
        return "genres/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("genre", new Genre());
        return "genres/form";
    }

    @PostMapping
    public String saveGenre(@ModelAttribute Genre genre) {
        genreService.save(genre);
        return "redirect:/genres";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Genre genre = genreService.findById(id).orElseThrow();
        model.addAttribute("genre", genre);
        return "genres/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteGenre(@PathVariable Long id) {
        genreService.deleteById(id);
        return "redirect:/genres";
    }
}
