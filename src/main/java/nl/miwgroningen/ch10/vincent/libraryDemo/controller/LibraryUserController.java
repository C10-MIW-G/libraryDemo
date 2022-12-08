package nl.miwgroningen.ch10.vincent.libraryDemo.controller;

import nl.miwgroningen.ch10.vincent.libraryDemo.model.LibraryUser;
import nl.miwgroningen.ch10.vincent.libraryDemo.model.dto.LibraryUserDTO;
import nl.miwgroningen.ch10.vincent.libraryDemo.repository.LibraryUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Allow changes to the userbase
 */

@Controller
@RequestMapping("/user")
public class LibraryUserController {
    private final PasswordEncoder passwordEncoder;
    private final LibraryUserRepository libraryUserRepository;

    public LibraryUserController(PasswordEncoder passwordEncoder, LibraryUserRepository libraryUserRepository) {
        this.passwordEncoder = passwordEncoder;
        this.libraryUserRepository = libraryUserRepository;
    }

    @GetMapping("/new")
    protected String showNewUserForm(Model model) {
        model.addAttribute("libraryUser", new LibraryUserDTO());
        return "userForm";
    }

    @PostMapping("/new")
    protected String saveOrUpdateUser(@ModelAttribute("libraryUser") LibraryUserDTO userDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "userForm";
        }

        Optional<LibraryUser> user = userDTO.getLibraryUser(passwordEncoder);

        if (user.isEmpty()) {
            return "userForm";
        }

        libraryUserRepository.save(user.get());
        return "redirect:/";
    }
}
