package no.ntnu.gr12.krrr_project.services;

import no.ntnu.gr12.krrr_project.models.ShoppingCart;
import no.ntnu.gr12.krrr_project.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShoppingCartService {

    @Autowired
    ShoppingCartRepository repository;

    @Transactional
    public String addShoppingCart(ShoppingCart cart) {
        try {
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
    public String deleteShoppingCart(ShoppingCart cart) {
        if (repository.findById(cart.getCartID()).isPresent()) {
            try {
                repository.delete(cart);
                return "Cart has been deleted";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Cart does not exist in DB";
        }
    }
}
