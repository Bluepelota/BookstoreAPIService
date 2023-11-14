package com.BookDetails.BookDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<byAuthor> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<byAuthor> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public byAuthor createAuthor(byAuthor author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}