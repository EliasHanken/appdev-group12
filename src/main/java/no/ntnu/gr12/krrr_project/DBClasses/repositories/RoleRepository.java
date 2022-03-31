package no.ntnu.gr12.krrr_project.DBClasses.repositories;

import no.ntnu.gr12.krrr_project.DBClasses.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Thomas Ystenes
 * Interface for RoleRepository
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
}
