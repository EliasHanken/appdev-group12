package no.ntnu.gr12.krrr_project.repositories;

import no.ntnu.gr12.krrr_project.models.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, String> {
}
