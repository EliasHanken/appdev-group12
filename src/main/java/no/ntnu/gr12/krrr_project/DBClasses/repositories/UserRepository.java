package no.ntnu.gr12.krrr_project.DBClasses.repositories;

import no.ntnu.gr12.krrr_project.DBClasses.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, String>{

}
