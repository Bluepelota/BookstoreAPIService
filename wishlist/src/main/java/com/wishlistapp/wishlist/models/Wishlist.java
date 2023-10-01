package com.wishlistapp.wishlist.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private Long userID;
    private List books = new ArrayList<>();

    public Long getId() {
        return id;
    }


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List books) {
        this.books = books;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}

