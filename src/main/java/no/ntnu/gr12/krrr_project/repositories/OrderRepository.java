package no.ntnu.gr12.krrr_project.repositories;

import no.ntnu.gr12.krrr_project.models.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface class that extends from the CrudRepository interface.
 * @author Anders M. H. Frostrud
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

}
