package no.ntnu.gr12.krrr_project.services;

import no.ntnu.gr12.krrr_project.models.*;
import no.ntnu.gr12.krrr_project.repositories.OrderRepository;
import no.ntnu.gr12.krrr_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.lang.model.element.Element;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Service class for the orders. Keeps the orders in an organized list and
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository Orderrepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;

    @Transactional
    public boolean addOrder(List<String> orderDetails) {
        if(orderDetails != null) {
            try {
                User currentUser = null;
                for (User u : userService.readUsers()) {
                    if (u.getUsername().equalsIgnoreCase(orderDetails.get(1))) {
                        currentUser = u;
                    }
                }
                if(currentUser != null) {
                    Order newOrder = new Order();
                    newOrder.setDestination(orderDetails.get(0));
                    newOrder.setShippedFlag(false);
                    //TODO wtf, way too ugly
                    newOrder.setItems(copyItemList(currentUser.getCart().getItems()));
                    newOrder.setUserId(currentUser.getId());
                    Orderrepository.save(newOrder);
                    return true;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        } return false;
    }

    public Iterable<Order> readOrders() {
        return Orderrepository.findAll();
    }

    @Transactional
    public String updateOrders(Long id,String newDest, boolean newFlag) {
        if (Orderrepository.findById(id).isPresent()) {
            try {
                Order orderToUpdate = Orderrepository.findById(id).get();
                orderToUpdate.setDestination(newDest);
                orderToUpdate.setShippedFlag(newFlag);
                return "Order info is updated";
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        } else {
            return "Order does not exist in DB";
        }
    }

    @Transactional
    public String deleteOrder(Long transactionId) {
        if (Orderrepository.existsById(transactionId)) {
            try {
                Orderrepository.deleteById(transactionId);
                return "Order has been deleted";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Order does not exist in DB";
        }
    }

    /**
     * Creates new items from an existing list and adds them to a new list as to avoid duplicate ID's
     * @param list the list of items to copy
     * @return the new list with a copy of the items from the old.
     */
    private List<Item> copyItemList(List<Item> list) {
        List<Item> copiedList = new ArrayList<>();
        for(Item i : list) {
            if (i instanceof Helmet) {
                Helmet newHelmet = new Helmet();
                newHelmet.setModelNumber(i.getModelNumber());
                newHelmet.setPrice(i.getPrice());
                itemService.addItem(newHelmet);
                copiedList.add(newHelmet);
            }
            else if (i instanceof Sunglasses) {
                Sunglasses newSunglasses = new Sunglasses();
                newSunglasses.setModelNumber(i.getModelNumber());
                newSunglasses.setPrice(i.getPrice());
                itemService.addItem(newSunglasses);
                copiedList.add(newSunglasses);
            }
            else if (i instanceof Chalk) {
                Chalk newChalk = new Chalk();
                newChalk.setModelNumber(i.getModelNumber());
                newChalk.setPrice(i.getPrice());
                itemService.addItem(newChalk);
                copiedList.add(newChalk);
            }
            else if (i instanceof TextileBag) {
                TextileBag newBag = new TextileBag();
                newBag.setModelNumber(i.getModelNumber());
                newBag.setPrice(i.getPrice());
                itemService.addItem(newBag);
                copiedList.add(newBag);
            }
        }
        return copiedList;
    }
}