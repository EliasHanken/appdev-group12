package no.ntnu.gr12.krrr_project.repositories;

import no.ntnu.gr12.krrr_project.models.Bike;
import org.springframework.data.repository.CrudRepository;

public interface BikeRepository extends CrudRepository<Bike, Long> {
    /*public List<Bike> findByName(String name);

    @Query("select bk.name from Bike bk")
    public Bike findBikeName();

    // Could be used.
     */
}
