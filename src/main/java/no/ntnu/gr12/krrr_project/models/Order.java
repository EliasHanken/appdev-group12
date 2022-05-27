package no.ntnu.gr12.krrr_project.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
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

    public void setItemId(Long itemId, Long newID) {

    }

    public void addItem(Item obj){
        items.add(obj);
    }

    public void addProduct(Object obj){

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

    public Long getTransactionId() {
        return transactionId;
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
