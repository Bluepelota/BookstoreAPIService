package com.BookDetails.BookDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/theBookDetails")

public class BookDetailController {
    
    private final BookDetailService bookDetailService;

    @Autowired
    public BookDetailController(BookDetailService bookDetailService)    {
        this.bookDetailService = bookDetailService;
    }

    @GetMapping("getAllBooks")
    public List<bookDetails> getAllBooks()   {
        return bookDetailService.getAllBooks();
    }

    @GetMapping("getBookByIsbn/{isbn}")
    public ResponseEntity<bookDetails> getBookByIsbn(@PathVariable String isbn) {
        bookDetails book = bookDetailService.getBookByIsbn(isbn);

        if (book != null)   {
            return ResponseEntity.ok(book);
        } else  {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/createBook")
    public ResponseEntity<String> createBook(@RequestBody BookRequestDTO bookRequestDTO)    {
       bookDetails newBook = convertToBookDetails(bookRequestDTO);
        bookDetailService.createBook(newBook);

        return ResponseEntity.ok("Successfully created a book");
    }

    private bookDetails convertToBookDetails(BookRequestDTO bookRequestDTO)  {
        bookDetails newBook = new bookDetails();
        newBook.setIsbn(bookRequestDTO.getIsbn());
        newBook.setBookName(bookRequestDTO.getBookName());
        newBook.setBookDescription(bookRequestDTO.getBookDescription());
        newBook.setPrice(bookRequestDTO.getPrice());
        newBook.setAuthor(bookRequestDTO.getAuthor());
        newBook.setGenre(bookRequestDTO.getGenre());
        newBook.setPublisher(bookRequestDTO.getPublisher());
        newBook.setYearPublished(bookRequestDTO.getYearPublished());
        newBook.setCopiesSold(bookRequestDTO.getCopiesSold());

        return newBook;

    }

}
