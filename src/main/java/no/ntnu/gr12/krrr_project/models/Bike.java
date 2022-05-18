package no.ntnu.gr12.krrr_project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bike {
    @Id
    @GeneratedValue
    private Long bikeId;

    private String description;

    private String bikeModel;

    public Bike(){
        this.bikeModel = "unknown";
    }

    public Bike(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    public String getBikeId() {
        return String.valueOf(bikeId);
    }

    public void setBikeId(String bikeId) {
        this.bikeId = Long.valueOf(bikeId);
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

    public String getBikeModel() {
        return bikeModel;
    }

    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }
}
