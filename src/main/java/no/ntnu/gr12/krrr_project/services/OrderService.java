package no.ntnu.gr12.krrr_project.services;

import no.ntnu.gr12.krrr_project.models.Order;
import no.ntnu.gr12.krrr_project.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service class for the orders. Keeps the orders in an organized list and
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional
    public String addOrder(Order order) {
        try {
            if (!repository.existsById(order.getTransactionId())) {
                repository.save(order);
                return "Order created";
            } else {
                return "Order is already in the database";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Iterable<Order> readOrders() {
        return repository.findAll();
    }

    @Transactional
    public String updateOrders(Order order) {
        if (repository.existsById(order.getTransactionId())) {
            try {
                Order orderToUpdate = repository.findById(order.getTransactionId()).get();
                orderToUpdate.setDestination(order.getDestination());
                orderToUpdate.setShippedFlag(order.isShippedFlag());
                repository.save(orderToUpdate);
                return "Order info updated";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Order does not exist in DB";
        }
    }

    @Transactional
    public String deleteOrder(Long transactionId) {
        if (repository.existsById(transactionId)) {
            try {
                repository.deleteById(transactionId);
                return "Order has been deleted";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Order does not exist in DB";
        }
    }
}