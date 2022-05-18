package no.ntnu.gr12.krrr_project.repositories;

import no.ntnu.gr12.krrr_project.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByUsername(String username);
}
