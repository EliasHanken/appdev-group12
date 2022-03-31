package no.ntnu.gr12.krrr_project.DBClasses.controllers;

import no.ntnu.gr12.krrr_project.DBClasses.services.BikeService;
import no.ntnu.gr12.krrr_project.DBClasses.models.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("/bikes")
    public List<Bike> getBikes(){
        return StreamSupport
                        .stream(bikeService.readBikes()
                        .spliterator(),false)
                        .collect(Collectors.toList());
    }

    @GetMapping("/bikes/{id}")
    public Bike getBike(@PathVariable String id){
        Iterator<Bike> it = bikeService.readBikes().iterator();

        while(it.hasNext()){
            Bike bikeFound = it.next();
            if(bikeFound.getBikeId().equalsIgnoreCase(id)){
                return bikeFound;
            }
        }
        return null;
    }

    @PostMapping("/bikes/addBike")
    public void addBike(@RequestBody Bike bike){
        bikeService.createBike(bike);
    }

    @PutMapping("bikes/updateBike/")
    public void updateBike(@RequestBody Bike bike){
        bikeService.updateBike(bike);
        }

    @DeleteMapping("bikes/deleteBike")
    public void deleteBike(@RequestBody Bike bike){
                bikeService.deleteBike(bike);
    }
}
