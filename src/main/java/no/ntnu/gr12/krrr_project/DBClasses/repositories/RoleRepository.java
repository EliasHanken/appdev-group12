package no.ntnu.gr12.krrr_project.DBClasses.repositories;

import no.ntnu.gr12.krrr_project.DBClasses.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Thomas Ystenes
 * Interface for RoleRepository
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findOneByName(String name);
}
