package no.ntnu.gr12.krrr_project.services;

import no.ntnu.gr12.krrr_project.models.Order;
import no.ntnu.gr12.krrr_project.models.ShoppingCart;
import no.ntnu.gr12.krrr_project.repositories.OrderRepository;
import org.aspectj.weaver.ast.Or;
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
    public boolean addOrder(Order order) {
        Order newOrder = new Order();
        try {
            if(order.getTransactionId() == null || order.getTransactionId().toString().equals("")){
                repository.save(order);
                return true;
            }
            if (!repository.existsById(order.getTransactionId())) {
                repository.save(order);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Iterable<Order> readOrders() {
        return repository.findAll();
    }

    @Transactional
    public String updateOrders(Long id,String newDest, boolean newFlag) {
        if (repository.findById(id).isPresent()) {
            try {
                Order orderToUpdate = repository.findById(id).get();
                orderToUpdate.setDestination(newDest);
                orderToUpdate.setShippedFlag(newFlag);
                return "Order info is updated";
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