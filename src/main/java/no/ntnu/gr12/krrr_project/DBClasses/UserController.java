package no.ntnu.gr12.krrr_project.DBClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getUsers() {
        return StreamSupport
                        .stream(userService.readUsers()
                        .spliterator(), false)
                        .collect(Collectors.toList());
    }

    @RequestMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        Iterator<User> it = userService.readUsers().iterator();

        while(it.hasNext()) {
            User userFound = it.next();
            if (userFound.getUserID().equals(id)) {
                return userFound;
            }
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateUser(@RequestBody User user) {
        userService.updateUsers(user);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/bikes/{id}")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }
}
