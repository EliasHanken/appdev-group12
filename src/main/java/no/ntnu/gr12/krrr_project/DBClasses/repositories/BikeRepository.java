package no.ntnu.gr12.krrr_project.DBClasses.repositories;

import no.ntnu.gr12.krrr_project.DBClasses.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BikeRepository extends CrudRepository<Bike, String> {
    /*public List<Bike> findByName(String name);

    @Query("select bk.name from Bike bk")
    public Bike findBikeName();

    // Could be used.
     */
}
