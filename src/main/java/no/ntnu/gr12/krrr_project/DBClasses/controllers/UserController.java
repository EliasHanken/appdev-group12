package no.ntnu.gr12.krrr_project.DBClasses.controllers;

import no.ntnu.gr12.krrr_project.DBClasses.services.UserService;
import no.ntnu.gr12.krrr_project.DBClasses.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //TODO must be fixed, gives an error when accessed.
    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUsers() {

        List<User> userList = new ArrayList<>();
        Iterator<User> it = userService.readUsers().iterator();

        while(it.hasNext()){
            userList.add(it.next());
        }
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {

        for (User userFound : userService.readUsers()) {
            if (userFound.getId().toString().equals(id)) {
                return userFound;
            }
        }
        return null;
    }

    @PostMapping(value = "/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
    @PutMapping(value = "/users/{id}")
    public void updateUser(@RequestBody User user) {
        userService.updateUsers(user);
    }
    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }
}
