package com.example.bookmanagement.controller;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.service.BookService;
import com.example.bookmanagement.service.GenreService;
import com.example.bookmanagement.service.PublisherService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final GenreService genreService;
    private final PublisherService publisherService;

    public BookController(BookService bookService, GenreService genreService, PublisherService publisherService) {
        this.bookService = bookService;
        this.genreService = genreService;
        this.publisherService = publisherService;
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("publishers", publisherService.findAll());
        return "books/form";
    }

    @PostMapping
    public String saveBook(@ModelAttribute("book") @Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("genres", genreService.findAll());
            model.addAttribute("publishers", publisherService.findAll());
            return "books/form";
        }
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("publishers", publisherService.findAll());
        return "books/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }
}
