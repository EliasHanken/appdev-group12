package no.ntnu.gr12.krrr_project.DBClasses.controllers;

import no.ntnu.gr12.krrr_project.DBClasses.models.User;
import no.ntnu.gr12.krrr_project.DBClasses.repositories.UserRepository;
import no.ntnu.gr12.krrr_project.DBClasses.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public void register(@RequestParam String name, @RequestParam String password){
        User test = new User();
        test.setId(543L);
        test.setDescription("idk");
        test.setUsername(name);
        test.setPassword(password);
    }
}
