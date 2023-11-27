package com.BookDetails.BookDetails;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDetailService {

    private final BookDetailRepository bookDetailRepository;

    @Autowired
    public BookDetailService(BookDetailRepository bookDetailRepository) {
        this.bookDetailRepository = bookDetailRepository;

    }

    public List<bookDetails> getAllBooks()   {
        return bookDetailRepository.findAll();
    }

    public bookDetails getBookByIsbn(String isbn)   {
        Optional<bookDetails> optionalBook = bookDetailRepository.findByIsbn(isbn);

        return optionalBook.orElse(null);
    }

    public bookDetails createBook(bookDetails bookDetails)  {
        
        return bookDetailRepository.save(bookDetails);

    }

}
