package no.ntnu.gr12.krrr_project.repositories;

import no.ntnu.gr12.krrr_project.models.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Thomas Ystenes
 * Interface for RoleRepository
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findOneByName(String name);
}
