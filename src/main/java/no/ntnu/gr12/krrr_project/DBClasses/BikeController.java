package no.ntnu.gr12.krrr_project.DBClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class BikeController {

    @Autowired
    private BikeService bikeService;

    public List<Bike> getBike(@PathVariable String id){

    }
}
