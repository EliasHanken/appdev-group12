package no.ntnu.gr12.krrr_project.services;

import no.ntnu.gr12.krrr_project.models.Bike;
import no.ntnu.gr12.krrr_project.models.Item;
import no.ntnu.gr12.krrr_project.models.ShoppingCart;
import no.ntnu.gr12.krrr_project.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    ShoppingCartRepository repository;
    @Autowired
    ItemService itemService;
    @Autowired
    BikeService bikeService;

    @Transactional
    public String addShoppingCart(ShoppingCart cart) {
        try {
            //TODO wonky solution by making ID into toString, but IDK should work?
            if(repository.findById(cart.getCartID()).isEmpty()) {
                repository.save(cart);
                return "Cart is saved";
            } else {
                return "Cart already exists";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Iterable<ShoppingCart> readCarts() {
        return repository.findAll();
    }

    @Transactional
    public String updateShoppingCart(ShoppingCart cart) {
        if (repository.findById(cart.getCartID()).isPresent()) {
            try {
                ShoppingCart cartToUpdate = repository.findById(cart.getCartID()).get();
                cartToUpdate.setCartID(cart.getCartID());
                return "Cart info is updated";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Cart does not exist in DB";
        }
    }

    @Transactional
    public boolean deleteShoppingCart(Long id) {
        if (repository.findById(id).isPresent()) {
            try {
                ShoppingCart currentCart = repository.findById(id).get();
                if(repository.findById(id).get().getUser().emptyCart()) {
                    repository.delete(currentCart);
                    return true;
                }
                else return false;
            } catch (Exception e) {
                throw e;
            }
        } else {
            return false;
        }
    }

    @Transactional
    public String emptyShoppingCartItems(Long id) {
        List<Item> itemsToDelete;
        if (repository.findById(id).isPresent()) {
            try {
                if(repository.findById(id).isPresent()) {
                    if(!repository.findById(id).get().getItems().isEmpty()) {
                        itemsToDelete = repository.findById(id).get().getItems();
                        for (Item i : itemsToDelete) {
                            itemService.deleteItem(i);
                    }
                    }
                    return "Cart has been been emptied";
                }
            } catch (Exception e) {
                throw e;
            }
        }
        return "Cart does not exist in DB";
    }

    @Transactional
    public String emptyShoppingCartBikes(Long id) {
        List<Bike> bikesToDelete;
        if (repository.findById(id).isPresent()) {
            try {
                if(repository.findById(id).isPresent()) {
                    if(!repository.findById(id).get().getBikes().isEmpty()) {
                        bikesToDelete = repository.findById(id).get().getBikes();
                        for (Bike b : bikesToDelete) {
                            bikeService.deleteBike(b);
                        }
                    }
                    return "Cart has been been emptied";
                }
            } catch (Exception e) {
                throw e;
            }
        }
        return "Cart does not exist in DB";
    }

    @Transactional
    public void deleteItem(Long id, int modelNumber) {
                if (repository.findById(id).isPresent()) {
                    if (!repository.findById(id).get().getBikes().isEmpty()) {
                        for (Bike b : repository.findById(id).get().getBikes()) {
                            if(Integer.toString(modelNumber).equalsIgnoreCase(b.getBikeModel()))
                                bikeService.deleteBike(b);
                        }
                    }
                    if (!repository.findById(id).get().getItems().isEmpty()) {
                        for (Item i : repository.findById(id).get().getItems())
                                if(Integer.toString(modelNumber).equalsIgnoreCase(i.getModelNumber())) {
                                    itemService.deleteItem(i);
                        }
                    }
                }
            }
}
