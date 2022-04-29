package no.ntnu.gr12.krrr_project.DBClasses.controllers;

import no.ntnu.gr12.krrr_project.DBClasses.models.User;
import no.ntnu.gr12.krrr_project.DBClasses.repositories.UserRepository;
import no.ntnu.gr12.krrr_project.DBClasses.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String name, @RequestParam String password){
        if(name != null && password != null){
            return new ResponseEntity<>(userService.addUser(new User(name,password)),HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid arguments",HttpStatus.BAD_REQUEST);
    }
}
