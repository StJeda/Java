package Domain.Models.Library;

import Domain.Abstractions.LibraryItem;

import java.util.List;

public class Almanac implements LibraryItem {
    private final String title;
    private final List<String> bookTitles;

    public Almanac(String title, List<String> bookTitles) {
        this.title = title;
        this.bookTitles = bookTitles;
    }

    public String getTitle() {
        return title;
    }

    public void displayInfo() {
        System.out.println("Almanac: " + title + "\nBooks included: " + String.join(", ", bookTitles));
    }
}