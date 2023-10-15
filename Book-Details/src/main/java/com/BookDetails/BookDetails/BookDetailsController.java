package com.BookDetails.BookDetails;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookDetails")
public class BookDetailsController {

    private final BookDetailsService bookDetailsService;

    @Autowired
    public BookDetailsController(BookDetailsService bookDetailsService)    {
        this.bookDetailsService = bookDetailsService;
    }

    @GetMapping
    public List<createBook> gettAllBooks()  {
        return bookDetailsService.getAllBooks();
    }

    @GetMapping("/{isbn}")
    public Optional<createBook> getBookByID(@PathVariable String isbn)    {
        return bookDetailsService.getBookById(isbn);
    }

    @PostMapping
    public createBook createBook(@RequestBody createBook book)  {
        return bookDetailsService.createBook(book);
    }

    @DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable String isbn)   {
        bookDetailsService.deleteBook(isbn);
    }
    
}
