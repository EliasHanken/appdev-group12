package no.ntnu.gr12.krrr_project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    @Lob
    /**Array of bytes forming product image.*/
    private byte[] imgData;

    private String description;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price, String description){
      this.name = name;
      this.price = price;
      this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

  public byte[] getImgData() { return imgData; }

  public void setImgData(byte[] imgData) { this.imgData = imgData; }

  public String getDescription() { return description; }

  public void setDescription(String description) { this.description = description; }
}
