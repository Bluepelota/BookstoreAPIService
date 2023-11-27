package com.BookDetails.BookDetails;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookDetailService {

    private final BookDetailRepository bookDetailRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookDetailService(BookDetailRepository bookDetailRepository, AuthorRepository authorRepository) {
        this.bookDetailRepository = bookDetailRepository;
        this.authorRepository = authorRepository;

    }

    public List<bookDetails> getAllBooks()   {
        return bookDetailRepository.findAll();
    }

    public bookDetails getBookByIsbn(String isbn)   {
        Optional<bookDetails> optionalBook = bookDetailRepository.findByIsbn(isbn);

        return optionalBook.orElse(null);
    }



    public List<bookDetails> getBooksByAuthorId(Long authorId)    {
        Optional<byAuthor> optionalAuthor = authorRepository.findById(authorId);
        return optionalAuthor.map(author -> bookDetailRepository.findByAuthor(author))
                            .orElse(Collections.emptyList());
    }
        
    public bookDetails createBook(BookRequestDTO bookRequestDTO) {
        byAuthor author = authorRepository.findById(bookRequestDTO.getAuthorId()).orElse(null);

        if (author != null) {
            bookDetails newBook = convertToBookDetails(bookRequestDTO);
            newBook.setAuthor(author);
            return bookDetailRepository.save(newBook);
        }

        return null; 
    }
    private bookDetails convertToBookDetails(BookRequestDTO bookRequestDTO) {
        bookDetails newBook = new bookDetails();
        newBook.setIsbn(bookRequestDTO.getIsbn());
        newBook.setBookName(bookRequestDTO.getBookName());
        newBook.setBookDescription(bookRequestDTO.getBookDescription());
        newBook.setPrice(bookRequestDTO.getPrice());
        newBook.setGenre(bookRequestDTO.getGenre());
        newBook.setPublisher(bookRequestDTO.getPublisher());
        newBook.setYearPublished(bookRequestDTO.getYearPublished());
        newBook.setCopiesSold(bookRequestDTO.getCopiesSold());

    

        return newBook;
    }

}
