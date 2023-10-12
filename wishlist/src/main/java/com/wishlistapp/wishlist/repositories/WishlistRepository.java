package com.wishlistapp.wishlist.repositories;

import com.wishlistapp.wishlist.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
}
