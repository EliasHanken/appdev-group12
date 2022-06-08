package no.ntnu.gr12.krrr_project.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

/**
 * A class that holds all items that are kept in a customer shopping cart
 * @author Anders M. H. Frostrud
 */

@Entity
@Table(name="shoppingCarts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long cartID;
    @OneToMany()
    private final List<Item> items;
    @OneToMany()
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> emptyCart() {
        List<Item> itemsToDelete = new ArrayList<>();
        if (!items.isEmpty()) {
            Iterator<Item> itemIterator = items.iterator();
            while (itemIterator.hasNext()) {
                itemsToDelete.add(itemIterator.next());
                itemIterator.remove();
            }
            /*Iterator<Bike> bikeIterator = bikes.iterator();
            while(itemIterator.hasNext()) {
                itemIterator.remove();
            }*/
        }
        return itemsToDelete;
    }
}
