package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.User;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SProjectApplication.class, args);
    }


    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        if (userRepository.findById(1L).isEmpty()) {
            User user = new User();
            user.setId(1L);
            User savedUser = userRepository.save(user);
            System.out.println("Saved User: " + savedUser.toString());
        }


        if (bookRepository.findById(1L).isEmpty()) {
            Book book = new Book();
            book.setTitle("Testing Book");
            book.setAuthor("Ron");
            book.setPrice(200.00);
            Book savedBook = bookRepository.save(book);
            System.out.println("Saved Book: " + savedBook.toString());

        }
    }
}
