package no.ntnu.gr12.krrr_project.DBClasses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {
    @Id
    private String transactionId;
    private String destination;
    private boolean shippedFlag;
    @OneToMany
    private List<Item> items = new ArrayList<>();
    @ManyToOne
    private User user;

    public Order() {
    }

    public List<Item> getItemId() {
        return items;
    }

    public void setItemId(String itemId, String newID) {
        for(Item i : items) {
            if(i.getItemID().equals(itemId)) {
                i.setItemID(newID);
            }
        }
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
                "transactionId='" + transactionId + '\'' +
                ", destination='" + destination + '\'' +
                ", shippedFlag=" + shippedFlag +
                ", items=" + items +
                '}';
    }
}
