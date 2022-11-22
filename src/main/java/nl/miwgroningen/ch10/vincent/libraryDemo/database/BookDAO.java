package nl.miwgroningen.ch10.vincent.libraryDemo.database;

import nl.miwgroningen.ch10.vincent.libraryDemo.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Haalt boeken uit de database
 */
public class BookDAO extends AbstractDAO {

    public BookDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();

        String sql = "SELECT title, author FROM Book;";
        try {
            setupPreparedStatement(sql);
            ResultSet resultSet = executeSelectStatement();
            while (resultSet.next()) {
                String title = resultSet.getString(1);
                String author = resultSet.getString(2);
                books.add(new Book(title, author));
            }
        } catch (SQLException sqlException) {
            sqlFoutmelding(sqlException);
        }

        return books;
    }
}
