package no.ntnu.gr12.krrr_project.repositories;

import no.ntnu.gr12.krrr_project.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Thomas Ystenes
 * Interface for RoleRepository
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findOneByName(String name);
}
