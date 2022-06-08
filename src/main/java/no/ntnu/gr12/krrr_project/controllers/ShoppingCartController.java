package no.ntnu.gr12.krrr_project.controllers;

import no.ntnu.gr12.krrr_project.models.*;
import no.ntnu.gr12.krrr_project.services.BikeService;
import no.ntnu.gr12.krrr_project.services.ItemService;
import no.ntnu.gr12.krrr_project.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import no.ntnu.gr12.krrr_project.models.ItemEnum;
import java.util.List;

@CrossOrigin(origins = {"*"}, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService cartService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private BikeService bikeService;

    @GetMapping("/api/cart/{cartID}/items")
    public List<Item> getItems(@PathVariable Long cartID) {
        ShoppingCart cart = new ShoppingCart();

        for (ShoppingCart cartFound : cartService.readCarts()) {
            if (cartFound.getCartID().equals(cartID)) {
                cart = cartFound;
            }
        }
        return cart.getItems();
    }

    @GetMapping("/api/cart/{cartID}/bikes")
    public List<Bike> getBikes(@PathVariable Long cartID) {
        ShoppingCart cart = new ShoppingCart();

        for (ShoppingCart cartFound : cartService.readCarts()) {
            if (cartFound.getCartID().equals(cartID)) {
                cart = cartFound;
            }
        }
        return cart.getBikes();
    }

    @PutMapping ("/api/cart/{cartID}/addItem/{modelNumber}")
    public void addItem(@PathVariable Long cartID, @PathVariable int modelNumber) {
        for (ShoppingCart cartFound : cartService.readCarts()) {
            if (cartFound.getCartID().equals(cartID)) {
                if (modelNumber == 1) {
                    Bike bikeToBeAdded = new Bike("1", "1", "Very nice bike", 123);
                    bikeService.createBike(bikeToBeAdded);
                    cartFound.addBike(bikeToBeAdded);
                }
                if (modelNumber == 2) {
                    Item itemToBeAdded = new Helmet(ItemEnum.HELMET_NORMAL.getModelNumber(), ItemEnum.HELMET_NORMAL.getPrice());
                    itemService.addItem(itemToBeAdded);
                    cartFound.addItem(itemToBeAdded);
                }
                if (modelNumber == 3) {
                    Item itemToBeAdded = new Sunglasses(ItemEnum.SUNGLASSES_BASIC.getModelNumber(), ItemEnum.CHALK_BASIC.getPrice());
                    itemService.addItem(itemToBeAdded);
                    cartFound.addItem(itemToBeAdded);
                }
                if (modelNumber == 4) {
                    Item itemToBeAdded = new TextileBag(ItemEnum.TEXTILE_BAG_BASIC.getModelNumber(), ItemEnum.TEXTILE_BAG_BASIC.getPrice());
                    itemService.addItem(itemToBeAdded);
                    cartFound.addItem(itemToBeAdded);
                }
                if (modelNumber == 5) {
                    Item itemToBeAdded = new Chalk(ItemEnum.CHALK_BASIC.getModelNumber(), ItemEnum.CHALK_BASIC.getPrice());
                    itemService.addItem(itemToBeAdded);
                    cartFound.addItem(itemToBeAdded);
                }
                cartService.updateShoppingCart(cartFound);
            }
        }

    }

    @PutMapping("/api/cart/{cartID}/emptyCart")
    public void emptyCart(@PathVariable Long cartID) {
        cartService.emptyShoppingCart(cartID);
    }

}
