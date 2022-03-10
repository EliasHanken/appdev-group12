package no.ntnu.gr12.krrr_project.DBClasses.Rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BikeService {
    //Used to reference to repository to save to DB.
    @Autowired
    BikeRepository repository;

    @Transactional
    public String createBike(Bike bike){
        try{
            if(!repository.existsById(bike.getBikeId())){
                repository.save(bike);
                return "Bike inserted!";
            }else{
                return "Bike already exists in the DB";
            }
        }catch (Exception e){
            throw e;
        }
    }

    public Iterable<Bike> readBikes(){
        return repository.findAll();
    }

    @Transactional
    public String updateBike(Bike bike){
        if(repository.existsById(bike.getBikeId())){
            try{
                Bike bikeToUpdate = repository.findById(bike.getBikeId()).get();
                bikeToUpdate.setDescription(bike.getDescription());
                repository.save(bikeToUpdate);
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
        if(repository.existsById(bike.getBikeId())){
            try{
                repository.delete(bike);
                return "Bike is deleted successfully!";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Bike does not exist in DB";
        }
    }
}
