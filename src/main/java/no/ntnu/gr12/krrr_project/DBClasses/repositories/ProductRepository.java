package no.ntnu.gr12.krrr_project.DBClasses.repositories;

import no.ntnu.gr12.krrr_project.DBClasses.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
