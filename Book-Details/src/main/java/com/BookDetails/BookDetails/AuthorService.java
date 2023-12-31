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

    public byAuthor getBookByFirstNameAndLastName(String firstName, String lastName)   {
        Optional<byAuthor> optionalAuthor = authorRepository.findByFirstNameAndLastName(firstName, lastName);

        return optionalAuthor.orElse(null);
    }

    public byAuthor saveAuthor(byAuthor byAuthor)  {
        
        return authorRepository.save(byAuthor);

    }
}