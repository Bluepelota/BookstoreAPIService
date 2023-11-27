package com.BookDetails.BookDetails;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDetailRepository extends JpaRepository<bookDetails, Long> {
    Optional<bookDetails> findByIsbn(String isbn);
    List<bookDetails> findByAuthor(byAuthor author);

}