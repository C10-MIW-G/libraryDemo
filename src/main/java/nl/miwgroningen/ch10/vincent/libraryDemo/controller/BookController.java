package nl.miwgroningen.ch10.vincent.libraryDemo.controller;

import nl.miwgroningen.ch10.vincent.libraryDemo.database.BookDAO;
import nl.miwgroningen.ch10.vincent.libraryDemo.database.DBaccess;
import nl.miwgroningen.ch10.vincent.libraryDemo.model.Book;
import org.apache.tomcat.websocket.BackgroundProcess;
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

    @GetMapping({"/books/all", "/"})
    protected String showBookOverview(Model model) {
        DBaccess dBaccess = new DBaccess("libraryDemo",
                "userLibrary", "userLibraryPW");
        dBaccess.openConnection();
        BookDAO bookDAO = new BookDAO(dBaccess);
        model.addAttribute("allBooks", bookDAO.getAllBooks());
        dBaccess.closeConnection();

        return "bookOverview";
    }
}
