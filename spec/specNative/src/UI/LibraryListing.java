package UI;

import Domain.Models.Library.Almanac;
import Domain.Models.Library.Book;
import Domain.Models.Library.Newspaper;
import Domain.Aggregate.LibraryCatalog;

import java.util.*;

public class LibraryListing {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LibraryCatalog catalog = new LibraryCatalog();

    public static void main(String[] args) {
        do {
            showMenu();
            int choice = getUserChoice();
            handleUserChoice(choice);
        } while (true);
    }

    private static void showMenu() {
        System.out.println("Select an action:");
        System.out.println("1. Add specific item");
        System.out.println("2. Add random item");
        System.out.println("3. Remove item by title");
        System.out.println("4. Search by title");
        System.out.println("5. Search by author");
        System.out.println("6. Display catalog");
        System.out.println("7. Display statistics");
        System.out.println("8. Display records");
        System.out.println("9. Exit");
    }

    private static int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private static void handleUserChoice(int choice) {
        switch (choice) {
            case 1 -> addSpecificItem();
            case 2 -> catalog.addRandomItem();
            case 3 -> removeItemByTitle();
            case 4 -> searchByTitle();
            case 5 -> searchByAuthor();
            case 6 -> catalog.displayCatalog();
            case 7 -> catalog.displayStatistics();
            case 8 -> catalog.displayRecords();
            case 9 -> {
                System.out.println("Exiting...");
                System.exit(0);
            }
            default -> System.out.println("Invalid choice, please try again.");
        }
    }

    private static void addSpecificItem() {
        System.out.println("Enter type of item (book/newspaper/almanac): ");
        String type = scanner.nextLine().toLowerCase();

        switch (type) {
            case "book" -> addBook();
            case "newspaper" -> addNewspaper();
            case "almanac" -> addAlmanac();
            default -> System.out.println("Invalid item type.");
        }
    }

    private static void addBook() {
        System.out.println("Enter author: ");
        String author = scanner.nextLine();
        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        System.out.println("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.println("Enter page count: ");
        int pageCount = scanner.nextInt();
        scanner.nextLine();

        catalog.addItem(new Book(author, title, genre, pageCount));
    }

    private static void addNewspaper() {
        System.out.println("Enter title: ");
        String newspaperTitle = scanner.nextLine();
        System.out.println("Enter issue date: ");
        String issueDate = scanner.nextLine();
        System.out.println("Enter headlines (comma separated): ");
        List<String> headlines = Arrays.asList(scanner.nextLine().split(","));
        catalog.addItem(new Newspaper(newspaperTitle, issueDate, headlines));
    }

    private static void addAlmanac() {
        System.out.println("Enter title: ");
        String almanacTitle = scanner.nextLine();
        System.out.println("Enter books included (comma separated): ");
        List<String> books = Arrays.asList(scanner.nextLine().split(","));
        catalog.addItem(new Almanac(almanacTitle, books));
    }

    private static void removeItemByTitle() {
        System.out.println("Enter title to remove: ");
        String titleToRemove = scanner.nextLine();
        catalog.removeItemByTitle(titleToRemove);
    }

    private static void searchByTitle() {
        System.out.println("Enter title to search: ");
        String searchTitle = scanner.nextLine();
        catalog.searchByTitle(searchTitle);
    }

    private static void searchByAuthor() {
        System.out.println("Enter author to search: ");
        String searchAuthor = scanner.nextLine();
        catalog.searchByAuthor(searchAuthor);
    }
}
