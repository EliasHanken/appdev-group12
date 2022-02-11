package no.ntnu.gr12.krrr_project.DBClasses;

import org.springframework.data.repository.CrudRepository;

public interface BikeRepository extends CrudRepository<Bike, String> {

    Bike findBikeById(String id);
}
