package no.ntnu.gr12.krrr_project.services;

import no.ntnu.gr12.krrr_project.models.Bike;
import no.ntnu.gr12.krrr_project.repositories.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BikeService {
    //Used to reference to repository to save to DB.
    @Autowired
    BikeRepository bikeRepository;

    @Transactional
    public String createBike(Bike bike){
        try {
                bikeRepository.save(bike);
                return "Bike inserted!";
            } catch(Exception e) {
            return "Bike already exists in the DB";
        }
    }

    public Iterable<Bike> readBikes(){
        return bikeRepository.findAll();
    }

    @Transactional
    public String updateBike(Bike bike){
        if(bikeRepository.existsById(bike.getBikeID())){
            try{
                Bike bikeToUpdate = bikeRepository.findById(bike.getBikeID()).get();
                bikeToUpdate.setDescription(bike.getDescription());
                bikeRepository.save(bikeToUpdate);
                return "Bike info updated";
            }catch (Exception e){
                throw e;
            }
        }else{
            return "Bike does not exist in the DB";
        }
    }

    @Transactional
    public String deleteBike(Bike bike){
        if (bikeRepository.findById(bike.getBikeID()).isPresent()) {
            try {
                bikeRepository.delete(bike);
                return "Bike has been deleted";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Bike does not exist in DB";
        }
    }
}
