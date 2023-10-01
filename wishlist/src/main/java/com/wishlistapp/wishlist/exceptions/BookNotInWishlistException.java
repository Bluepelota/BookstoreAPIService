package com.wishlistapp.wishlist.exceptions;

public class BookNotInWishlistException extends RuntimeException {
    public BookNotInWishlistException(String message) { super(message);}
}
