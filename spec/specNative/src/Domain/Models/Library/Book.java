package Domain.Models.Library;

import Domain.Abstractions.LibraryItem;

public class Book implements LibraryItem {
    private final String author;
    private final String title;
    private final String genre;
    private final int pageCount;

    public Book(String author, String title, String genre, int pageCount) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public void displayInfo() {
        System.out.println("Book: " + title + "\nAuthor: " + author + "\nGenre: " + genre + "\nPage Count: " + pageCount);
    }

    public String getAuthor() {
        return author;
    }
}
