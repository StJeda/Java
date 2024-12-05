package Domain.Models.Library;

import Domain.Abstractions.LibraryItem;

import java.util.List;

public class Newspaper implements LibraryItem {
    private final String title;
    private final String issueDate;
    private final List<String> headlines;

    public Newspaper(String title, String issueDate, List<String> headlines) {
        this.title = title;
        this.issueDate = issueDate;
        this.headlines = headlines;
    }

    public String getTitle() {
        return title;
    }

    public void displayInfo() {
        System.out.println("Newspaper: " + title + "\nIssue Date: " + issueDate + "\nHeadlines: " + String.join(", ", headlines));
    }
}
