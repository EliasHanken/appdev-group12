package no.ntnu.gr12.krrr_project.DBClasses.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Different simple endpoints
 */
@RestController
@CrossOrigin
public class HelloController {
    @GetMapping("")
    @PreAuthorize("")
    public String home(){
        return "This is a public home page";
    }

    @GetMapping("user")
    @PreAuthorize("hasRole('USER')")
    public String userPage(){
        return "This is accessible to all authorized users";
    }

    @GetMapping("admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminPage(){
        return "This is accessible only for ADMIN users";
    }
}
