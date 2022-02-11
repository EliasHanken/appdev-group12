package no.ntnu.gr12.krrr_project.DBClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Service class for the orders. Keeps the orders in an organized list and
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    private List<Order> orders = new ArrayList<>(Arrays.asList(
            new Order("Order 1", false, "Destination 1", 123, "User 1", "Item 1"),
            new Order("Order 2", false, "Destination 2", 321, "User 2", "Item 2")
    ));

    /**
     * Returns the orders as a list
     * @return the orders as a list
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Returns a specific order
     * @param id the id of the order to be returned
     * @return the order to be returned
     */
    public Order getOrder(String id) {
        return orders.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * Adds an order to the order list
     * @param order the order to be added
     */
    public void addOrder(Order order) {
        orders.add(order);
    }

    //TODO Update with a completely new object, what?
    /**
     * Updates an order with a new order object
     * @param id the id of the order to be updated
     * @param order the updated order
     */
    public void updateOrder(String id, Order order) {
        for(int i = 0; i < orders.size(); i++) {
            Order o = orders.get(i);
            if(o.getId().equals(id)) {
                orders.set(i, order);
                //TODO return in if statement?
                return;
            }
        }
    }

    /**
     * Deletes a specific order from the order list
     * @param id the id of the order to be deleted
     */
    public void deleteOrder(String id) {
        orders.removeIf(b -> b.getId().equals(id));
    }
}
