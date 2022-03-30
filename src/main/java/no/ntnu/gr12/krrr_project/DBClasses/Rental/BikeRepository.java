package no.ntnu.gr12.krrr_project.DBClasses.Rental;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, String> {
    /*public List<Bike> findByName(String name);

    @Query("select bk.name from Bike bk")
    public Bike findBikeName();

    // Could be used.
     */
}
