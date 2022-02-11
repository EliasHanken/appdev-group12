package no.ntnu.gr12.krrr_project.DBClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BikeService {
    //Used to reference to repository to save to DB.
    @Autowired
    BikeRepository repository;

    private List<Bike> bikes = new ArrayList<>(Arrays.asList(
            new Bike("1","1",false),
            new Bike("2","2",false)));

    public List<Bike> getBikes(){
        return bikes;
    }

    public Bike getBike(String id){
        return bikes.stream().filter(e -> e.getBikeId().equals(id)).findFirst().orElse(null);
    }

    public void addBike(Bike bike){
        bikes.add(bike);
    }

    public void updateBike(String id, Bike bike){
        for(int i = 0; i < bikes.size(); i++){
            Bike b = bikes.get(i);
            if(b.getBikeId().equals(id)){
                bikes.set(i,bike);
                return;
            }
        }
    }

    public void deleteBike(String id){
        bikes.removeIf(b -> b.getBikeId().equals(id));
    }
}
