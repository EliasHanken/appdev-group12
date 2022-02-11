package no.ntnu.gr12.krrr_project.DBClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class BikeController {

    @Autowired
    private BikeService bikeService;

    @RequestMapping("/bikes")
    public List<Bike> getBikes(){
        return bikeService.getBikes();
    }

    @RequestMapping("/bikes/{id}")
    public Bike getBike(@PathVariable String id){
        return bikeService.getBike(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/bikes")
    public void addBike(@RequestBody Bike bike){
        bikeService.addBike(bike);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/bikes/{id}")
    public void updateBike(@RequestBody Bike bike,@PathVariable String id){
        bikeService.updateBike(id,bike);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/bikes/{id}")
    public void deleteBike(@PathVariable String id){
        bikeService.deleteBike(id);
    }
}
