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

    public byAuthor getBookByFirstName(String firstName)   {
        Optional<byAuthor> optionalAuthor = authorRepository.findByFirstName(firstName);

        return optionalAuthor.orElse(null);
    }

    // public byAuthor getBookByLastName(String lastName)   {
    //     Optional<byAuthor> optionalAuthor = authorRepository.findByLastName(lastName);

    //     return optionalAuthor.orElse(null);
    // }

    public byAuthor createAuthor(byAuthor byAuthor)  {
        
        return authorRepository.save(byAuthor);

    }
}