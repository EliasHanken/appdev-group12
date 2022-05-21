package no.ntnu.gr12.krrr_project.repositories;

import no.ntnu.gr12.krrr_project.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface class that extends from the CrudRepository interface.
 * @author Anders M. H. Frostrud
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, String> {

}
