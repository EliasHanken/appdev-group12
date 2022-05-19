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

    /**Link to image of product*/
    private String imgLink;

    public Bike(){
        this.bikeModel = "unknown";
    }

    public Bike(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    public Bike(String bikeModel, String description, String imgLink) {
        this.bikeModel = bikeModel;
        this.description = description;
        this.imgLink = imgLink;
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
                ", imgLink='" + imgLink +
                '}';
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    public String getImgLink() { return imgLink; }

    public void setImgLink(String imgLink) { this.imgLink = imgLink; }
}
