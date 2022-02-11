package no.ntnu.gr12.krrr_project.DBClasses;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {
    @Id
    private String id;
    private boolean shippedFlag;
    private String destination;
    private float totalPrice;
    private String userKey;
    private String itemKey;


    public Order(String id, boolean shippedFlag, String destination, float totalPrice, String userKey, String itemKey) {
        this.id = id;
        this.shippedFlag = shippedFlag;
        this.destination = destination;
        this.totalPrice = totalPrice;
        this.userKey = userKey;
        this.itemKey = itemKey;
    }

    public Order() {
        this.id = "";
        this.shippedFlag = false;
        this.destination = "";
        this.totalPrice = 0;
        this.userKey = "";
        this.itemKey = "";
    }

    public String getId() {
        return id;
    }

    public boolean isShippedFlag() {
        return shippedFlag;
    }

    public String getDestination() {
        return destination;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public String getUserKey() {
        return userKey;
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setShippedFlag(boolean shippedFlag) {
        this.shippedFlag = shippedFlag;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }
}
