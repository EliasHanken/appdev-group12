package no.ntnu.gr12.krrr_project.repositories;

import no.ntnu.gr12.krrr_project.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, String> {
}
