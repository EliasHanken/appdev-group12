package no.ntnu.gr12.krrr_project.controllers;

import no.ntnu.gr12.krrr_project.services.OrderService;
import no.ntnu.gr12.krrr_project.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Controller class for the orders. Controls the HTTP requests and parses it from the OrderService class.
 *
 * @author Anders M. H. Frostrud
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * Returns the Order list through the /orders mapping.
     * @return the orders as a list
     */
    @RequestMapping("/orders")
    public List<Order> getOrders() {
        return StreamSupport
                .stream(orderService.readOrders()
                        .spliterator(),false)
                .collect(Collectors.toList());
    }

    /**
     * Returns a specific order through the /orders mapping
     * @param id the id of the order to be requested
     * @return the specific order
     */
    @RequestMapping("/orders/{id}")
    public Order getOrder(@PathVariable String id) {
        Iterator<Order> it = orderService.readOrders().iterator();

        while (it.hasNext()) {
            Order orderFound = it.next();
            if (orderFound.getTransactionId().equals(id)) {
                return orderFound;
            }
        }
        return null;
    }

    /**
     * Adds an order to the order list in orderService class through the /orders mapping
     * @param order the order to be added
     */
    @RequestMapping(method = RequestMethod.POST, value = "/orders")
    public void addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }

    /**
     * Updates a specific order with a new order through the mapping.
     * @param order the updated order
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/orders/{id}")
    public void updateOrder(@RequestBody Order order) {
        orderService.updateOrders(order);
    }

    /**
     * Deletes a specific order through the mapping
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/orders/{id}")
    public void deleteOrder(@PathVariable Order order) {
        orderService.deleteOrder(order);
    }
}
