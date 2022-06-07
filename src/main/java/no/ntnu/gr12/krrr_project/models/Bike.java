package no.ntnu.gr12.krrr_project.models;

import javax.persistence.*;

@Entity
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bikeID;

    /**Should be supplied in amount per min, I.E, 1 = 1kr/minute*/
    private double price = 1;

    private String description;

    private String bikeModel;

    private String bikeModelName;

    @ManyToOne(cascade = CascadeType.ALL)
    private ShoppingCart cart;

    @ManyToOne
    private Order order;

    /**Id of image of product*/
    private int imgId;

    /**Array of bytes forming product image.*/
    @Lob
    private byte[] imgData;


    public Bike(){
        //this.bikeModel = "unknown";
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

    public Long getBikeID() {
        return bikeID;
    }

    public void setBikeID(Long bikeId) {
        this.bikeID = bikeId;
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
                "id=" + bikeID +
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
