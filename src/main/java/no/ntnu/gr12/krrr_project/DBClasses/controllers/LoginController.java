package no.ntnu.gr12.krrr_project.DBClasses.controllers;

import no.ntnu.gr12.krrr_project.DBClasses.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/login")
    @PreAuthorize("hasRole('USER')")
    public String login(@RequestParam String username,@RequestParam String password){
        return "Currently logged in!";
    }
}
