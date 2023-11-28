package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.CartItem;
import com.example.bookstore.model.User;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.CartRepository;
import com.example.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public CartItem addBookToCart(Long userId, Long bookId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

        CartItem cartItem = new CartItem();
        cartItem.setUserId(user.getId());
        cartItem.setBookId(book.getId());

        return cartRepository.save(cartItem);
    }

    public double calculateSubtotal(Long userId) {
        List<CartItem> userCartItems = cartRepository.findByUserId(userId);
        return userCartItems.stream()
                .mapToDouble(cartItem -> {
                    Book book = bookRepository.findById(cartItem.getBookId()).orElseThrow(() -> new RuntimeException("Book not found"));
                    return book.getPrice();
                })
                .sum();
    }

    public List<Book> getBooksInCart(Long userId) {
        List<CartItem> cartItems = cartRepository.findByUserId(userId);
        return cartItems.stream()
                .map(cartItem -> bookRepository.findById(cartItem.getBookId()).orElseThrow(() -> new RuntimeException("Book not found")))
                .collect(Collectors.toList());
    }

    public void deleteBookFromCart(Long userId, Long bookId) {
        CartItem cartItem = cartRepository.findByUserIdAndBookId(userId, bookId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cartRepository.delete(cartItem);
    }
}
