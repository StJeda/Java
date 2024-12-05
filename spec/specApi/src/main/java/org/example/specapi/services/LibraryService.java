package org.example.specapi.services;

import lombok.extern.slf4j.Slf4j;
import org.example.specapi.abstractions.LibraryItem;
import org.example.specapi.models.Library.Almanac;
import org.example.specapi.models.Library.Book;
import org.example.specapi.models.Library.Newspaper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class LibraryService {
    private final List<LibraryItem> catalog = new ArrayList<>();

    public List<LibraryItem> getCatalog() {
        log.info("Fetching library catalog with {} items", catalog.size());
        return catalog;
    }

    public String addBook(Book book) {
        catalog.add(book);
        log.info("Added book: {}", book);
        return "Book added successfully";
    }

    public String addNewspaper(Newspaper newspaper) {
        catalog.add(newspaper);
        log.info("Added newspaper: {}", newspaper);
        return "Newspaper added successfully";
    }

    public String addAlmanac(Almanac almanac) {
        catalog.add(almanac);
        log.info("Added almanac: {}", almanac);
        return "Almanac added successfully";
    }

    public String removeItem(String name) {
        Optional<LibraryItem> removedItem = catalog.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findFirst();

        removedItem.ifPresent(catalog::remove);
        if (removedItem.isPresent()) {
            log.info("Removed item: {}", removedItem.get());
            return "Item removed successfully";
        } else {
            log.warn("No item found with name: {}", name);
            return "Item not found";
        }
    }
}
