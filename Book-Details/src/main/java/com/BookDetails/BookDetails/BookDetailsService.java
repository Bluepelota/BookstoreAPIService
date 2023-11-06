package com.BookDetails.BookDetails;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDetailsService {

    private final bookRepository bookRepository;

    @Autowired
    public BookDetailsService(bookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<createBook> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<createBook> getBookById(String isbn) {
        return bookRepository.findById(isbn);
    }

    public createBook createBook(createBook book) {
        book.setPrice(book.getprice());
        book.setCopiesSold(book.getCopiesSold());
        return bookRepository.save(book);
    }

    public void deleteBook(String isbn) {
        bookRepository.deleteById(isbn);
    }
}

