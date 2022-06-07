package no.ntnu.gr12.krrr_project.models;

import javax.persistence.*;

/**
 * Abstract class that contains all the items sold in the website for the database
 *
 * @author Tor Oveland Gikling
 * @version 0.0.1
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract public class Item {

    @Id
    @SequenceGenerator(name = "itemGenerator", initialValue = 2000, allocationSize = 1)
    @GeneratedValue(generator = "itemGenerator")
    private Long itemID;

    private String modelNumber;
    private float price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartID")
    private ShoppingCart cart;
    /**Link to image of product*/
    private String imgLink;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderID")
    private Order order;

    public Item(String modelNumber, float price) {
        this.modelNumber = modelNumber;
        this.price = price;
    }

    public Item(String modelNumber, float price, String imgLink) {
        this.modelNumber = modelNumber;
        this.price = price;
        this.imgLink = imgLink;
    }

    public Item() {
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

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }
}
