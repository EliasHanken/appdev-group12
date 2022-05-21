package no.ntnu.gr12.krrr_project.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that holds all items that are kept in a customer shopping cart
 * @author Anders M. H. Frostrud
 */

@Entity
@Table(name="shoppingCarts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartID;
    @OneToMany(cascade = { CascadeType.ALL})
    private final List<Item> items;
    @OneToMany(cascade = {CascadeType.ALL})
    private final List<Bike> bikes;
    @OneToOne
    private User user;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.bikes = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
    public void addBike(Bike bike) {
        this.bikes.add(bike);
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public Long getCartID() {
        return cartID;
    }

    public void setCartID(Long cartID) {
        this.cartID = cartID;
    }
}
