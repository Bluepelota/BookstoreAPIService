package com.example.site.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart") // Controller's base URL
public class ShoppingCartRestController {

    @Autowired
    private ShoppingCartServices cartServices;

    @Autowired
    private ProfileServices profileServices;

    /**
     * Adds a product to the cart.
     *
     * @param productId Product ID.
     * @param quantity Product quantity.
     * @return Quantity added.
     */
    @PostMapping("/add")
    public Integer add(@RequestParam Integer productId, @RequestParam Integer quantity) {
        Profile profile = profileServices.getCurrentlyLoggedInCustomer();
        if (profile == null) {
            throw new IllegalStateException("User not signed in");
        }
        return cartServices.addProduct(productId, quantity, profile);
    }

    /**
     * Removes a product from the cart.
     *
     * @param productId Product ID.
     */
    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer productId) {
        Profile profile = profileServices.getCurrentlyLoggedInCustomer();
        if (profile == null) {
            throw new IllegalStateException("User not signed in");
        }
        cartServices.deleteProduct(profile, productId);
    }

    /**
     * Updates product quantity in the cart.
     *
     * @param userId User ID.
     * @param productId Product ID.
     * @param quantity New product quantity.
     * @return Updated total amount.
     */
    @PutMapping("/update")
    public Double update(@RequestParam Long userId, @RequestParam Integer productId, @RequestParam Integer quantity) {
        return cartServices.update(userId, productId, quantity);
    }
}
