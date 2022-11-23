package nl.miwgroningen.ch10.vincent.libraryDemo.controller;

import nl.miwgroningen.ch10.vincent.libraryDemo.database.BookDAO;
import nl.miwgroningen.ch10.vincent.libraryDemo.database.DBaccess;
import nl.miwgroningen.ch10.vincent.libraryDemo.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Geeft toegang tot alle pagina's over boeken
 */

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping({"/books/all", "/"})
    protected String showBookOverview(Model model) {
        model.addAttribute("allBooks", bookRepository.findAll());

        return "bookOverview";
    }
}
