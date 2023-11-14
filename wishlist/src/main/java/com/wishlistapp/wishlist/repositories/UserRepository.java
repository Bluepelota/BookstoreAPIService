package com.wishlistapp.wishlist.repositories;

import com.wishlistapp.wishlist.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);

    List<User> findByName(String name);

    User findByEmail(String email);

    List<User> findByHomeAddress(String homeAddress);

    User findByUsernameAndPassword(String username, String password);

}
