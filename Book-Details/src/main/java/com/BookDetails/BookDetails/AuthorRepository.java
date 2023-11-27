package com.BookDetails.BookDetails;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<byAuthor, Long> {
    Optional<byAuthor> findByFirstName(String firstName);
    // Optional<byAuthor> findByLastName(String lastName);
}
