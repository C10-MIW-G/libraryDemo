package nl.miwgroningen.ch10.vincent.libraryDemo.model.dto;

import lombok.Getter;
import lombok.Setter;
import nl.miwgroningen.ch10.vincent.libraryDemo.model.LibraryUser;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * User object to send to Form
 */

@Getter @Setter
public class LibraryUserDTO {
    private Long libraryUserId;
    private String username;
    private String password;
    private String passwordCheck;

    public LibraryUserDTO(LibraryUser libraryUser) {
        libraryUserId = libraryUser.getLibraryUserId();
        username = libraryUser.getUsername();
    }

    public LibraryUserDTO() {
    }

    public Optional<LibraryUser> getLibraryUser(PasswordEncoder passwordEncoder) {
        if (!password.equals(passwordCheck)) {
            return Optional.empty();
        }

        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setLibraryUserId(libraryUserId);
        libraryUser.setUsername(username);
        libraryUser.setPassword(passwordEncoder.encode(password));

        return Optional.of(libraryUser);
    }
}
