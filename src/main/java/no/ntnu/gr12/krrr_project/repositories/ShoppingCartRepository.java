package no.ntnu.gr12.krrr_project.repositories;

import no.ntnu.gr12.krrr_project.models.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
