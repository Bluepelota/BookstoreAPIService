package com.example.site.shoppingcart;

import com.example.site.entity.ShoppingCart;
import com.example.site.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface for ShoppingCart CRUD operations using Spring Data JPA.
 */
public interface CartRepo extends JpaRepository<ShoppingCart, Integer> {

    /**
     * Retrieves shopping carts for a user.
     *
     * @param user Target user.
     * @return List of user's carts.
     */
    List<ShoppingCart> findByUser(User user);

    /**
     * Deletes a product from a user's cart.
     *
     * @param user      Target user.
     * @param productId Product to delete.
     */
    void deleteByUserAndProductId(User user, Integer productId);

    // For updates, fetch the cart, modify, then use save().
}
