package com.BookDetails.BookDetails;

import java.util.List;

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

    public bookDetails createBook(BookRequestDTO bookRequest)   {
        bookDetails bookDetails = new bookDetails();
        bookDetails.setisbn(bookRequest.getIsbn());
        bookDetails.setBookName(bookRequest.getBookName());
        bookDetails.setBookDescription(bookRequest.getBookDescription());
        bookDetails.setPrice(bookRequest.getPrice());
        bookDetails.setAuthor(bookRequest.getAuthor());
        bookDetails.setGenre(bookRequest.getGenre());
        bookDetails.setPublisher(bookRequest.getPublisher());
        bookDetails.setYearPublished(bookRequest.getYearPublished());
        bookDetails.setCopiesSold(bookRequest.getCopiesSold());

    }

}
