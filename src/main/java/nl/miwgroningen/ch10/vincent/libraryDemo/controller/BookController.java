package nl.miwgroningen.ch10.vincent.libraryDemo.controller;

import nl.miwgroningen.ch10.vincent.libraryDemo.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Geeft toegang tot alle pagina's over boeken
 */

@Controller
public class BookController {

    @GetMapping("/books")
    protected String showBookOverview(Model model) {
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setTitle("Name of the Wind");
        book.setAuthor("P. Rothfuss");
        books.add(book);

        Book book2 = new Book();
        book2.setTitle("The Wise Man's Fear");
        book2.setAuthor("P. Rothfuss");
        books.add(book2);

        model.addAttribute("allBooks", books);

        return "bookOverview";
    }
}
