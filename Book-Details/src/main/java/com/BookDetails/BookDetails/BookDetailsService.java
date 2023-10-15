package com.BookDetails.BookDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDetailsService {

    private final bookRepository repository;

    @Autowired
    public BookDetailsService(bookRepository repository)    {
        this.repository = repository;
    }
    
}
