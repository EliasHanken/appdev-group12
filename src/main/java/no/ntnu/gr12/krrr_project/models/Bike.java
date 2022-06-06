package no.ntnu.gr12.krrr_project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Bike {

    @Id
    @GeneratedValue
    private Long bikeId;

    /**Should be supplied in amount per min, I.E, 1 = 1kr/minute*/
    private double price = 1;

    private String description;

    private String bikeModel;

    private String bikeModelName;

    /**Id of image of product*/
    private int imgId;


    /**Array of bytes forming product image.*/
    @Lob
    private byte[] imgData;

    public Bike(){
        this.bikeModel = "unknown";
    }

    public Bike(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    public Bike(String bikeModel, String description, int imgId) {
        this.bikeModel = bikeModel;
        this.description = description;
        this.imgId = imgId;
    }

    public Bike(String bikeModel, String bikeModelName, String description, int imgId){
      this.bikeModel = bikeModel;
      this.bikeModelName = bikeModelName;
      this.description = description;
      this.imgId = imgId;
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
                ", Image='" + imgId +
                '}';
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    public int getImgId() { return imgId; }

    public void setImgId(int imgId) { this.imgId = imgId; }

  public String getBikeModelName() {
    return bikeModelName;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setBikeModelName(String bikeModelName) {
    this.bikeModelName = bikeModelName;
  }

  public byte[] getImgData() {
    return imgData;
  }

  public void setImgData(byte[] imgData) {
    this.imgData = imgData;
  }
}
