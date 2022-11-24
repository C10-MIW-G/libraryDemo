package nl.miwgroningen.ch10.vincent.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Our library has physical copies of books
 */

@Entity @Getter @Setter
public class Copy {
    @Id
    @GeneratedValue
    private Long copyId;

    @ManyToOne
    private Book book;

    Boolean available = true;
}
