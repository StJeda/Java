package org.example.specapi.abstractions;

import java.util.List;

public interface ILibraryCatalog {
    void initializeCatalog();

    String addItem(LibraryItem item);

    String addRandomItem();

    String removeItemByName(String name);

    List<LibraryItem> getAllItems();

    LibraryItem searchByName(String name);

    List<LibraryItem> searchByAuthor(String author);
}

