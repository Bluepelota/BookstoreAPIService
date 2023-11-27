package com.BookDetails.BookDetails;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<byAuthor, Long> {
    Optional<byAuthor> findByFirstNameAndLastName(String firstName, String lastName);
   
}
