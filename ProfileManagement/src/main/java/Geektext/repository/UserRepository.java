package Geektext.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import profilemanagement.demo.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    
    List<User> findByName(String name);
    
    User findByEmailAddress(String emailAddress);
    
    List<User> findByHomeAddress(String homeAddress);

    User findByUsernameAndPassword(String username, String password);



}