package com.BookDetails.BookDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface bookRepository extends JpaRepository<createBook, String> {
    
    
}

