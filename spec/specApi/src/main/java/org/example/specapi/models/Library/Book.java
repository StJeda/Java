package org.example.specapi.models.Library;

import org.example.specapi.abstractions.LibraryItem;

public record Book(String author, String name, String genre, int pages) implements LibraryItem {
    @Override
    public String getName() {
        return this.name    ;
    }

    @Override
    public String getType() {
        return "Book";
    }
}
