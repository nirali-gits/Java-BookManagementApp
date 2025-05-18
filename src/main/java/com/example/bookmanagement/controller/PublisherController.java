package com.example.bookmanagement.controller;

import com.example.bookmanagement.model.Publisher;
import com.example.bookmanagement.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public String listPublishers(Model model) {
        model.addAttribute("publishers", publisherService.findAll());
        return "publishers/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publishers/form";
    }

    @PostMapping
    public String savePublisher(@ModelAttribute Publisher publisher) {
        publisherService.save(publisher);
        return "redirect:/publishers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Publisher publisher = publisherService.findById(id).orElseThrow();
        model.addAttribute("publisher", publisher);
        return "publishers/form";
    }

    @GetMapping("/delete/{id}")
    public String deletePublisher(@PathVariable Long id) {
        publisherService.deleteById(id);
        return "redirect:/publishers";
    }
}
