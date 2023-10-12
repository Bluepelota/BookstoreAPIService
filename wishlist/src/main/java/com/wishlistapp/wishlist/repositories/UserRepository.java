package com.wishlistapp.wishlist.repositories;

import com.wishlistapp.wishlist.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
