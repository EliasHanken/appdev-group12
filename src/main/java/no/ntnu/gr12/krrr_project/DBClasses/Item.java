package no.ntnu.gr12.krrr_project.DBClasses;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Abstract class that contains all the items sold in the website for the database
 *
 * @author Tor Oveland Gikling
 * @version 0.0.1
 */
@Entity
abstract public class Item {
    @Id
    private String itemID;
    private String modelNumber;
    private float price;

    public Item(String itemID, String modelNumber, float price) {
        this.itemID = itemID;
        this.modelNumber = modelNumber;
        this.price = price;
    }

    public Item() {
    }


    @Id
    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
