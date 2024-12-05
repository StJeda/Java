package Domain.Aggregate;

import Domain.Abstractions.LibraryItem;
import Domain.Models.Library.Almanac;
import Domain.Models.Library.Book;
import Domain.Models.Library.Newspaper;
import java.io.*;
import java.util.*;

public class LibraryCatalog {
    private final List<LibraryItem> items;
    private final Map<String, Integer> statistics;
    private final Map<String, Integer> recordStatistics;

    public LibraryCatalog() {
        this.items = new ArrayList<>();
        this.statistics = new HashMap<>();
        this.recordStatistics = new HashMap<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
        logAction("Added: " + item.getTitle());
        updateStatistics(item);
        updateRecords(item);
    }

    public void addRandomItem() {
        Random random = new Random();

        LibraryItem item = null;

        if (random.nextBoolean()) {
            item = new Book("Author " + random.nextInt(100), "Book " + random.nextInt(100), "Genre " + random.nextInt(5), random.nextInt(500) + 50);
        } else if (random.nextBoolean()) {
            item = new Newspaper("Newspaper " + random.nextInt(100), "2024-12-" + random.nextInt(31), List.of("Headline 1", "Headline 2"));
        } else {
            item = new Almanac("Almanac " + random.nextInt(100), List.of("Book A", "Book B", "Book C"));
        }
        addItem(item);
    }

    public void removeItemByTitle(String title) {
        items.removeIf(item -> item.getTitle().equalsIgnoreCase(title));
        logAction("Removed: " + title);
    }

    public void searchByTitle(String title) {
        items.stream()
                .filter(item -> item.getTitle().equalsIgnoreCase(title))
                .forEach(LibraryItem::displayInfo);
    }

    public void searchByAuthor(String author) {
        items.stream()
                .filter(item -> item instanceof Book && ((Book) item).getAuthor().equalsIgnoreCase(author))
                .forEach(LibraryItem::displayInfo);
    }

    public void displayCatalog() {
        if (items.isEmpty()) {
            System.out.println("Catalog is empty.");
        } else {
            items.forEach(LibraryItem::displayInfo);
        }
    }

    private void logAction(String action) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("catalog_log.txt", true))) {
            writer.write(action + " at " + new Date() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateStatistics(LibraryItem item) {
        String key = item.getTitle();
        statistics.put(key, statistics.getOrDefault(key, 0) + 1);
    }

    private void updateRecords(LibraryItem item) {
        String itemType = item.getClass().getSimpleName();
        recordStatistics.put(itemType, recordStatistics.getOrDefault(itemType, 0) + 1);
    }

    public void displayStatistics() {
        System.out.println("Statistics of added items by title:");
        statistics.forEach((key, value) -> System.out.println("Title: " + key + ", Added: " + value + " times"));
    }

    public void displayRecords() {
        System.out.println("Record statistics by item type:");
        recordStatistics.forEach((key, value) -> System.out.println("Item Type: " + key + ", Added: " + value + " times"));
    }
}

