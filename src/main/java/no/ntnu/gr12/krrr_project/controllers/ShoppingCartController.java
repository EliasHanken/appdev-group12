package no.ntnu.gr12.krrr_project.controllers;

import no.ntnu.gr12.krrr_project.models.Bike;
import no.ntnu.gr12.krrr_project.models.Item;
import no.ntnu.gr12.krrr_project.models.ShoppingCart;
import no.ntnu.gr12.krrr_project.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService cartService;

    @GetMapping("/cart/{cartID}/items")
    public List<Item> getItems(@PathVariable Long cartID) {
        ShoppingCart cart = new ShoppingCart();

        for (ShoppingCart cartFound : cartService.readCarts()) {
            if (cartFound.getCartID().equals(cartID)) {
                cart = cartFound;
            }
        }
        return cart.getItems();
    }

    @GetMapping("/cart/{cartID}/bikes")
    public List<Bike> getBikes(@PathVariable Long cartID) {
        ShoppingCart cart = new ShoppingCart();

        for (ShoppingCart cartFound : cartService.readCarts()) {
            if (cartFound.getCartID().equals(cartID)) {
                cart = cartFound;
            }
        }
        return cart.getBikes();
    }

}
