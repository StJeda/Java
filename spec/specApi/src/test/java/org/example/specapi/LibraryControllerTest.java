package org.example.specapi;

import org.example.specapi.controllers.LibraryController;
import org.example.specapi.models.Library.Book;
import org.example.specapi.services.LibraryService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryControllerTest {

    @Test
    public void testAddBook() {
        LibraryService libraryService = new LibraryService();
        LibraryController controller = new LibraryController(libraryService);

        Book book = new Book("Author", "Book Title", "Fiction", 100);
        String response = controller.addBook(book);

        assertEquals("Book added successfully", response);
        assertTrue(controller.getCatalog().contains(book));
    }

    @Test
    public void testRemoveItem() {
        LibraryService libraryService = new LibraryService();
        LibraryController controller = new LibraryController(libraryService);

        Book book = new Book("Author", "Book Title", "Fiction", 100);
        controller.addBook(book);

        String response = controller.removeItem("Book Title");

        assertEquals("Item removed if found", response);
        assertFalse(controller.getCatalog().contains(book));
    }
}
