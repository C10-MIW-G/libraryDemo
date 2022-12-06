package nl.miwgroningen.ch10.vincent.libraryDemo.model;

import nl.miwgroningen.ch10.vincent.libraryDemo.repository.BookRepository;
import nl.miwgroningen.ch10.vincent.libraryDemo.repository.CopyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookTest {
    @Test
    @DisplayName("Available copies, all copies available")
    void availableCopiesAllCopiesAvailable() {
        // Arrange
        Book book = new Book();

        for (int i = 0; i < 3; i++) {
            book.addCopy(new Copy());
        }

        int expectedAvailableCopies = 3;

        // Activate
        int availableCopies = book.getNumberOfAvailableCopies();

        // Assert
        Assertions.assertEquals(expectedAvailableCopies, availableCopies);
    }

    @Test
    @DisplayName("Available copies, some copies available")
    void availableCopiesSomeCopiesAvailable() {
        // Arrange
        Book book = new Book();

        for (int i = 0; i < 3; i++) {
            Copy copy = new Copy();
            if (i % 2 == 0) {
                copy.setAvailable(false);
            }
            book.addCopy(copy);
        }

        int expectedAvailableCopies = 1;

        // Activate
        int availableCopies = book.getNumberOfAvailableCopies();

        // Assert
        Assertions.assertEquals(expectedAvailableCopies, availableCopies);
    }

    @Test
    @DisplayName("Available copies, no copies available")
    void availableCopiesNoCopiesAvailable() {
        // Arrange
        Book book = new Book();

        for (int i = 0; i < 3; i++) {
            Copy copy = new Copy();
            copy.setAvailable(false);
            book.addCopy(copy);
        }

        int expectedAvailableCopies = 0;

        // Activate
        int availableCopies = book.getNumberOfAvailableCopies();

        // Assert
        Assertions.assertEquals(expectedAvailableCopies, availableCopies);
    }

}