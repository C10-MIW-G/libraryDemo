package nl.miwgroningen.ch10.vincent.libraryDemo.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {

    @Test
    @DisplayName("DisplayNameWithInfixName")
    void displayNameWithInfixName() {
        // Arrange
        Author author = new Author("Vincent", "van", "Velthuizen");
        String expectedAuthorName = "Vincent van Velthuizen";

        // Activate
        String authorName = author.getDisplayName();

        // Assert
        assertEquals(expectedAuthorName, authorName);
    }

    @Test
    @DisplayName("Display name without infix name")
    void displayNameWithoutInfixName() {
        // Arrange
        Author author = new Author("Vincent", "Velthuizen");
        String expectedAuthorName = "Vincent Velthuizen";

        // Activate
        String authorName = author.getDisplayName();

        // Assert
        assertEquals(expectedAuthorName, authorName);
    }

}