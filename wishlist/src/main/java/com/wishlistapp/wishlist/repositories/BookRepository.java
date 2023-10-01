package com.wishlistapp.wishlist.repositories;



import com.wishlistapp.wishlist.models.Book;
import com.wishlistapp.wishlist.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{}