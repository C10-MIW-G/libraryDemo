package nl.miwgroningen.ch10.vincent.libraryDemo.model;

import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Somebody who writes books
 */

@Entity @Getter @Setter
public class Author {

    private static final String DEFAULT_INFIX_NAME = "";
    @Id
    @GeneratedValue
    private Long authorId;

    private String firstName;
    private String infixName;
    private String lastName;

    public Author(String firstName, String infixName, String lastName) {
        this.firstName = firstName;
        this.infixName = infixName;
        this.lastName = lastName;
    }

    public Author(String firstName, String lastName) {
        this(firstName, DEFAULT_INFIX_NAME, lastName);
    }

    public Author() {
    }

    public String getDisplayName() {
        String displayName = firstName;

        if (!infixName.equals("")) {
            displayName += " " + infixName;
        }

        return displayName + " " + lastName;
    }

    @Override
    public String toString() {
        return getDisplayName();
    }
}
