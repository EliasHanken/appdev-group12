package no.ntnu.gr12.krrr_project.DBClasses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BikeRepository extends JpaRepository<Bike, String> {
    /*public List<Bike> findByName(String name);

    @Query("select bk.name from Bike bk")
    public Bike findBikeName();

    // Could be used.
     */
}
