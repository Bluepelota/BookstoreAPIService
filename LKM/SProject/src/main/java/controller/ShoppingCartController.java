package controller;

import model.Book;
import service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {

    @Autowired
    private CartService cartService;  // Assuming the service name is CartService

    // Retrieve the subtotal price of all items in the user’s shopping cart
    @GetMapping("/subtotal")
    public ResponseEntity<Double> getSubtotal(@RequestParam Long userId) {
        double subtotal = cartService.calculateSubtotal(userId);
        return new ResponseEntity<>(subtotal, HttpStatus.OK);
    }

    // Add a book to the shopping cart
    @PostMapping("/add")
    public ResponseEntity<Void> addBookToCart(@RequestParam Long userId, @RequestParam Long bookId) {
        cartService.addBookToCart(userId, bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Retrieve the list of book(s) in the user’s shopping cart
    @GetMapping("/list")
    public ResponseEntity<List<Book>> getBooksInCart(@RequestParam Long userId) {
        List<Book> books = cartService.getBooksInCart(userId);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // Delete a book from the shopping cart
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteBookFromCart(@RequestParam Long userId, @RequestParam Long bookId) {
        cartService.deleteBookFromCart(userId, bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
