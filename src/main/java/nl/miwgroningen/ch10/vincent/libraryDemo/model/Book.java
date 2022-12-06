package nl.miwgroningen.ch10.vincent.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Dit is een boek
 */

@Entity @Getter @Setter
public class Book {

    @Id
    @GeneratedValue
    private Long bookId;

    private String title;

    @ManyToMany
    private Set<Author> authors;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Copy> copies;

    public Book() {
        copies = new ArrayList<>();
    }

    public int getNumberOfAvailableCopies() {
        int count = 0;

        for (Copy copy : copies) {
            if (copy.getAvailable()) {
                count++;
            }
        }

        return count;
    }

    public String getAuthorsDisplayString() {
        StringBuilder builder = new StringBuilder();

        for (Author author : authors) {
            builder.append(author).append(", ");
        }

        return builder.toString();
    }

    public void addCopy(Copy copy) {
        copies.add(copy);
    }
}
