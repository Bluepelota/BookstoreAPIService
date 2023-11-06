package com.BookDetails.BookDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService)    {
        this.authorService = authorService;
    }

    @GetMapping
    public List<byAuthor> getAllAuthors()   {
        return authorService.getAllAuthors();
    }
    
}
