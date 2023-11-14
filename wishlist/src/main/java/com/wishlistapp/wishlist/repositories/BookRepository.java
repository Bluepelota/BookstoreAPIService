package com.wishlistapp.wishlist.repositories;



import com.wishlistapp.wishlist.models.Book;
import com.wishlistapp.wishlist.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{}