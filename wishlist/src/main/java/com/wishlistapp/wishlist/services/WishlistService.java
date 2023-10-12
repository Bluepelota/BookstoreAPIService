
package com.wishlistapp.wishlist.services;

import com.wishlistapp.wishlist.exceptions.*;
import com.wishlistapp.wishlist.models.*;
import com.wishlistapp.wishlist.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {
    private WishlistRepository wishlistRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;


    public void createWishlist(Long userId){
        // Assuming user is already created. The userRepository must have a method findUserById(Long userId).
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));

        // Create a new wishlist
        Wishlist wishlist = new Wishlist();
        wishlist.setUserId(userId);
    }

  public void addBookToWishlist(Long bookId, Long wishlistId){
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book not found"));
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElseThrow(() -> new WishlistNotFoundException("Wishlist not found"));

        if(!wishlist.getBooks().contains(bookId)){
            wishlist.getBooks().add(book);
            wishlistRepository.save(wishlist);
        } else {
            throw new BookAlreadyAddedException("Book with ID "+ bookId + " is already in your wishlist.");
        }
    }

    public void removeBookFromWishlist(Long bookId, Long wishlistId){
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book not found"));
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElseThrow(() -> new WishlistNotFoundException("Wishlist not found"));

        if(!wishlist.getBooks().contains(bookId)){
            wishlist.getBooks().remove(book);
            wishlistRepository.save(wishlist);
        } else {
            throw new BookNotInWishlistException("Book with ID "+ bookId + " is already not in your wishlist.");
        }
    }

    public List<Book> getBooksInWishlist(Long wishlistId){
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElseThrow(() -> new WishlistNotFoundException("Wishlist not found"));
        return wishlist.getBooks();
    }
}
