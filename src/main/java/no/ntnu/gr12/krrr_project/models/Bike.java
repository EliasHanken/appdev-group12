package no.ntnu.gr12.krrr_project.models;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CartID")
    private ShoppingCart cart;

    @ManyToOne()
    @JoinColumn(name = "OrderID")
    private Order order;

    /**Id of image of product*/
    private int imgId;

    /**Array of bytes forming product image.*/
    @Lob
    private byte[] imgData;

    /**True if bike is currently on loan, else false.*/
    private boolean onLoan;

    private LocalDateTime loanStartTime;

    public Bike(){
        this.onLoan = false;
        this.bikeModel = "unknown";
    }

    public Bike(String bikeModel) {
        this.bikeModel = bikeModel;
      this.onLoan = false;
    }


    public Bike(String bikeModel, String description, int imgId) {
        this.bikeModel = bikeModel;
        this.description = description;
        this.imgId = imgId;
        this.onLoan = false;
    }

    public Bike(String bikeModel, String bikeModelName, String description, int imgId){
      this.bikeModel = bikeModel;
      this.bikeModelName = bikeModelName;
      this.description = description;
      this.imgId = imgId;
      this.onLoan = false;
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

  public boolean isOnLoan() {
    return onLoan;
  }

  public void setOnLoan(boolean onLoan) {
    this.onLoan = onLoan;
  }

  public LocalDateTime getLoanStartTime() {
    return loanStartTime;
  }

  public void setLoanStartTime(LocalDateTime loanStartTime) {
    this.loanStartTime = loanStartTime;
  }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
