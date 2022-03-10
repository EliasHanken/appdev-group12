package no.ntnu.gr12.krrr_project.DBClasses.Rental;

import jdk.jshell.execution.Util;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Bike {
    @Id
    private String bikeId;

    private String description;

    public Bike() {
    }

    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "Bike{" +
                "id=" + bikeId +
                ", description='" + description + '\''+
                '}';
    }
}
