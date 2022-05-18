package no.ntnu.gr12.krrr_project.services;

import no.ntnu.gr12.krrr_project.models.User;
import no.ntnu.gr12.krrr_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public String addUser(User user) {
        try {
            if(repository.findByUsername(user.getUsername()).isEmpty()) {
                repository.save(user);
                return "User created";
            } else {
                return "User already exists";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Iterable<User> readUsers() {
        return repository.findAll();
    }

    @Transactional
    public String updateUsers(User user) {
        if (repository.findByUsername(user.getUsername()).isPresent()) {
            try {
                User userToUpdate = repository.findByUsername(user.getUsername()).get();
                userToUpdate.setDescription(user.getDescription());
                repository.save(userToUpdate);
                return "user info updated";
            } catch (Exception e) {
                throw e;
            }
        }else {
            return "User does not exist in DB";
    }
    }

    @Transactional
    public String deleteUser(User user) {
        if (repository.findByUsername(user.getUsername()).isPresent()) {
            try {
                repository.delete(user);
                return "user has been deleted";
            }catch (Exception e) {
                throw e;
            }
        }else {
            return "User deos not exist in DB";
        }
    }

}
