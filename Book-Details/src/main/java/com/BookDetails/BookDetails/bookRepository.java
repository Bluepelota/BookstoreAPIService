package com.BookDetails.BookDetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepository extends JpaRepository<createBook, String> {
    
    
}

