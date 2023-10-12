package com.wishlistapp.wishlist.controllers;


import com.wishlistapp.wishlist.models.Book;
import com.wishlistapp.wishlist.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    @Autowired
    public WishlistController(WishlistService wishlistService){
        this.wishlistService = wishlistService;
    }

    @PostMapping("/create") // Resultant endpoint = /api/wishlist/create
    public ResponseEntity<Void> createWishlist(@RequestParam Long userId){
        wishlistService.createWishlist(userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/addBook") // Resultant endpoint = /api/wishlist/addBook
    public ResponseEntity<Void> addBookToWishlist(@RequestParam Long bookId, @RequestParam Long wishlistId){
        wishlistService.addBookToWishlist(bookId, wishlistId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/removeBook") // Resultant endpoint = /api/wishlist/removeBook
    public ResponseEntity<Void> removeBookFromWishlist(@RequestParam Long bookId, @RequestParam Long wishlistId){
        wishlistService.removeBookFromWishlist(bookId, wishlistId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getBooks") // Resultant endpoint = /api/wishlist/getBooks
    public ResponseEntity<List<Book>> getBooksInWishlist(@RequestParam Long wishlistId){
        List<Book> books = wishlistService.getBooksInWishlist(wishlistId);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    
 @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}