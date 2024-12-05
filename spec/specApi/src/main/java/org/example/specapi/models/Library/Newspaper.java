package org.example.specapi.models.Library;



import org.example.specapi.abstractions.LibraryItem;

import java.util.Date;
import java.util.List;

public record Newspaper(String name, Date date, List<String> headlines) implements LibraryItem {
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return "Newspaper";
    }
}