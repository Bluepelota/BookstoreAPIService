package com.BookDetails.BookDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
