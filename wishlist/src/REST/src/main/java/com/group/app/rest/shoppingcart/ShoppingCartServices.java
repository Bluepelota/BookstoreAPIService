package com.example.site.shoppingcart;

import java.util.List;
import com.example.site.entity.ShoppingCart;
import com.example.site.entity.User;
import com.example.site.entity.BookBrowsing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServices {

    @Autowired
    private com.example.site.shoppingcart.CartRepo cartRepo;

    @Autowired
    private BookBrowsingRepo bookRepo; // Repository to manage book operations

    // Fetch all items in the user's cart
    public List<ShoppingCart> listAll(User profile) {
        return cartRepo.findByUser(profile);
    }

    /**
     * Add a book to the user's cart.
     * @param productId ID of the book
     * @param quantity Quantity to add
     * @param user The user whose cart is being updated
     * @return The new total quantity of the book in the cart
     */
    public Integer addBook(Integer productId, Integer quantity, User user) {
        BookBrowsing book = bookRepo.findById(productId).orElse(null);
        if (book == null) {
            throw new RuntimeException("Book not found");
        }

        ShoppingCart shoppingCart = cartRepo.findByUserAndProductId(user, productId);
        if (shoppingCart != null) {
            quantity += shoppingCart.getQuantity();
            shoppingCart.setQuantity(quantity);
        } else {
            shoppingCart = new ShoppingCart();
            shoppingCart.setQuantity(quantity);
            shoppingCart.setUser(user);
            shoppingCart.setProduct(book);
        }
        cartRepo.save(shoppingCart);
        return quantity;
    }

    // Delete a specific book from the user's cart
    public void deleteBook(User user, Integer productId) {
        cartRepo.deleteByUserIdAndProductId(user.getId(), productId);
    }

    /**
     * Update the quantity of a book in the user's cart.
     * @param user The user whose cart is being updated
     * @param productId ID of the book
     * @param quantity New quantity to set
     * @return The total price after the update
     */
    public double updateBook(User user, Integer productId, Integer quantity) {
        ShoppingCart cartItem = cartRepo.findByUserAndProductId(user, productId);
        if (cartItem != null) {
            cartItem.setQuantity(quantity);
            cartRepo.save(cartItem);
        } else {
            // Handle error.
        }

        BookBrowsing book = bookRepo.findById(productId).orElse(null);
        if (book == null) {
            throw new RuntimeException("Book not found");
        }

        return book.getPrice() * quantity; // Calculate the total price
    }
}
