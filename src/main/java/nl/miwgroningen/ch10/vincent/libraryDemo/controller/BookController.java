package nl.miwgroningen.ch10.vincent.libraryDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Geeft toegang tot alle pagina's over boeken
 */

@Controller
public class BookController {

    @GetMapping("/books")
    protected String showBookOverview() {
        return "bookOverview";
    }
}
