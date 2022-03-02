package no.ntnu.gr12.krrr_project.DBClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class BikeController {

    @Autowired
    private BikeService bikeService;

    @RequestMapping("/bikes")
    public List<Bike> getBikes(){
        return StreamSupport
                        .stream(bikeService.readBikes()
                        .spliterator(),false)
                        .collect(Collectors.toList());
    }

    @RequestMapping("/bikes/{id}")
    public Bike getBike(@PathVariable String id){
        Iterator<Bike> it = bikeService.readBikes().iterator();

        while(it.hasNext()){
            Bike bikeFound = it.next();
            if(bikeFound.getBikeId().equals(id)){
                return bikeFound;
            }
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/bikes")
    public void addBike(@RequestBody Bike bike){
        bikeService.createBike(bike);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/bikes/{id}")
    public void updateBike(@RequestBody Bike bike){
        bikeService.updateBike(bike);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/bikes/{id}")
    public void deleteBike(@RequestBody Bike bike){
        bikeService.deleteBike(bike);
    }
}
