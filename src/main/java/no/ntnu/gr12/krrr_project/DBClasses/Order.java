package no.ntnu.gr12.krrr_project.DBClasses;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {
    private String itemId;
    @Id
    private String transactionId;
    private String destination;
    private boolean shippedFlag;

    public Order() {
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public boolean isShippedFlag() {
        return shippedFlag;
    }

    public void setShippedFlag (boolean shipped) {
        this.shippedFlag = shipped;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.setTransactionId(transactionId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "transactionId=" + transactionId +
                ", itemId=" + itemId +
                ", destination='" + destination + "\'" +
                "}";
    }
}
