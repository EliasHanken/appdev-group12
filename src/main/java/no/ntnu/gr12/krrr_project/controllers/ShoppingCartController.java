package no.ntnu.gr12.krrr_project.controllers;

import no.ntnu.gr12.krrr_project.models.Bike;
import no.ntnu.gr12.krrr_project.models.Helmet;
import no.ntnu.gr12.krrr_project.models.Item;
import no.ntnu.gr12.krrr_project.models.ShoppingCart;
import no.ntnu.gr12.krrr_project.services.ItemService;
import no.ntnu.gr12.krrr_project.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService cartService;
    @Autowired
    private ItemService itemService;

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

    @PutMapping("/cart/{cartID}/addItem")
    public void addHelmet(@PathVariable Long cartID, @RequestBody Helmet helmet) {
        Helmet itemToBeAdded = new Helmet(helmet.getModelNumber(), helmet.getPrice());
        itemToBeAdded.setItemID(helmet.getItemID());
        itemService.addItem(itemToBeAdded);
        for (ShoppingCart cartFound : cartService.readCarts()) {
            if (cartFound.getCartID().equals(cartID)) {
                cartFound.addItem(itemToBeAdded);
                cartService.updateShoppingCart(cartFound);
            }
        }
    }

}
