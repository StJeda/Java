package org.example.specapi.models.Library;

import org.example.specapi.abstractions.LibraryItem;

import java.util.List;

public record Almanac(String name, List<String> books) implements LibraryItem {
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return "Almanac";
    }
}