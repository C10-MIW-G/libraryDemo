package nl.miwgroningen.ch10.vincent.libraryDemo;

import nl.miwgroningen.ch10.vincent.libraryDemo.model.LibraryUser;
import nl.miwgroningen.ch10.vincent.libraryDemo.repository.LibraryUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@SpringBootApplication
public class LibraryDemoKickstarter implements CommandLineRunner {
    private final LibraryUserRepository libraryUserRepository;
    private final PasswordEncoder passwordEncoder;

    public LibraryDemoKickstarter(LibraryUserRepository libraryUserRepository, PasswordEncoder passwordEncoder) {
        this.libraryUserRepository = libraryUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (libraryUserRepository.findAll().size() == 0) {
            LibraryUser user = new LibraryUser();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("admin"));
            libraryUserRepository.save(user);
        }
    }
}
