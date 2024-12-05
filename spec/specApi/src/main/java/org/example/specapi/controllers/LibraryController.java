package org.example.specapi.controllers;


import org.example.specapi.models.Library.Almanac;
import org.example.specapi.models.Library.Book;
import org.example.specapi.models.Library.Newspaper;
import org.example.specapi.services.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public List<?> getCatalog() {
        return libraryService.getCatalog();
    }

    @PostMapping("/add/book")
    public String addBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    @PostMapping("/add/newspaper")
    public String addNewspaper(@RequestBody Newspaper newspaper) {
        return libraryService.addNewspaper(newspaper);
    }

    @PostMapping("/add/almanac")
    public String addAlmanac(@RequestBody Almanac almanac) {
        return libraryService.addAlmanac(almanac);
    }

    @DeleteMapping("/remove/{name}")
    public String removeItem(@PathVariable String name) {
        return libraryService.removeItem(name);
    }
}

