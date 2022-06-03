package no.ntnu.gr12.krrr_project.controllers;

import no.ntnu.gr12.krrr_project.dto.OrderUpdateRequest;
import no.ntnu.gr12.krrr_project.repositories.OrderRepository;
import no.ntnu.gr12.krrr_project.services.OrderService;
import no.ntnu.gr12.krrr_project.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Controller class for the orders. Controls the HTTP requests and parses it from the OrderService class.
 *
 * @author Anders M. H. Frostrud
 */
//TODO Move most of logic from methods to service classes
@CrossOrigin(origins = {"*"}, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    /**
     * Returns the Order list through the /orders mapping.
     * @return the orders as a list
     */
    @RequestMapping("api/orders")
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
    @RequestMapping("api/orders/{id}")
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
    @RequestMapping(method = RequestMethod.POST, value = "api/orders/new")
    public ResponseEntity<String> addOrder(Order order) {
        if(orderService.addOrder(order)) {
            return new ResponseEntity<String>("Order successfully created", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<String>("Order not added, something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(method = RequestMethod.PUT, value = "api/orders/{id}")
    public void updateOrder(@RequestBody OrderUpdateRequest orderUpdateRequest) {
        orderService.updateOrders(Long.valueOf(orderUpdateRequest.getId()),orderUpdateRequest.getDestination(),Boolean.parseBoolean(orderUpdateRequest.getShippedFlag()));
    }

    /**
     * Deletes a specific order through the mapping
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "api/orders/{id}")
    public void deleteOrder(@PathVariable String id) {
        Long longTransactionId = Long.valueOf(id);
        orderService.deleteOrder(longTransactionId);
    }
}
