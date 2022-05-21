package no.ntnu.gr12.krrr_project.controllers;

import no.ntnu.gr12.krrr_project.models.Bike;
import no.ntnu.gr12.krrr_project.models.Helmet;
import no.ntnu.gr12.krrr_project.models.Item;
import no.ntnu.gr12.krrr_project.models.ShoppingCart;
import no.ntnu.gr12.krrr_project.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService cartService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/cart/{cartID}/items")
    public List<Item> getItems(@PathVariable Long cartID) {
        List<Item> itemsToReturn = new ArrayList<>();

        for (ShoppingCart cartFound : cartService.readCarts()) {
            if (cartFound.getCartID() == (cartID)) {
                itemsToReturn = cartFound.getItems();
            }
        }
        return itemsToReturn;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/cart/{cartID}/bikes")
    public List<Bike> getBikes(@PathVariable Long cartID) {
        ShoppingCart cart = new ShoppingCart();

        for (ShoppingCart cartFound : cartService.readCarts()) {
            if (cartFound.getCartID() == (cartID)) {
                cart = cartFound;
            }
        }
        return cart.getBikes();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/cart/{cartID}/addItem")
    public ResponseEntity<String> addItem(@PathVariable Long cartID, @RequestBody Helmet helmet) {
        for (ShoppingCart cartFound : cartService.readCarts()) {
            if (cartFound.getCartID() == (cartID)) {
                /*if(item.getItemID().charAt(3) == '2') {
                    cartFound.addItem(item);

                }
            */
                Helmet itemToBeAdded = new Helmet(helmet.getHelmetID(), helmet.getModelNumber(), helmet.getPrice());
                cartFound.addItem(itemToBeAdded);
                return new ResponseEntity<>("Item correctly added", HttpStatus.OK);
            }

        }
        return new ResponseEntity<>("Error: cart not found", HttpStatus.NOT_FOUND);
    }
}
