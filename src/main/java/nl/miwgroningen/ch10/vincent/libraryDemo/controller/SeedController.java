package nl.miwgroningen.ch10.vincent.libraryDemo.controller;

import nl.miwgroningen.ch10.vincent.libraryDemo.model.Author;
import nl.miwgroningen.ch10.vincent.libraryDemo.model.Book;
import nl.miwgroningen.ch10.vincent.libraryDemo.model.Copy;
import nl.miwgroningen.ch10.vincent.libraryDemo.repository.AuthorRepository;
import nl.miwgroningen.ch10.vincent.libraryDemo.repository.BookRepository;
import nl.miwgroningen.ch10.vincent.libraryDemo.repository.CopyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Allow for quick adding of data to the DB
 */

@Controller
public class SeedController {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CopyRepository copyRepository;

    public SeedController(AuthorRepository authorRepository,
                          BookRepository bookRepository,
                          CopyRepository copyRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.copyRepository = copyRepository;
    }


    @GetMapping("/seed")

    protected String seedDatabase() {
        Author patrick = new Author();
        patrick.setFirstName("Patrick");
        patrick.setInfixName("");
        patrick.setLastName("Rothfuss");

        authorRepository.save(patrick);

        Set<Author> authors = new HashSet<>();
        authors.add(patrick);

        Book book = new Book();
        book.setAuthors(authors);
        book.setTitle("The Name of the Wind");

        bookRepository.save(book);

        Copy copy = new Copy();
        copy.setBook(book);

        copyRepository.save(copy);

        return "redirect:/";
    }
}
