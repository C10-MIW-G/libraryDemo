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

    @Id
    @GeneratedValue
    private Long authorId;

    private String firstName;
    private String infixName;
    private String lastName;

    public String getDisplayName() {
        String displayName = firstName;

        if (!infixName.equals("")) {
            displayName += " " + infixName;
        }

        return displayName + " " + lastName;
    }
}
