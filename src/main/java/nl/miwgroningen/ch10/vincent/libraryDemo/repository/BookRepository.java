package nl.miwgroningen.ch10.vincent.libraryDemo.repository;

import nl.miwgroningen.ch10.vincent.libraryDemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Deals with DB interaction for us
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
