package com.BookDetails.BookDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("getAllAuthors")
    public List<byAuthor> getAllAuthors()   {
        return authorService.getAllAuthors();
    }

    @GetMapping("getBookByFirstName/{firstName}")
    public ResponseEntity<byAuthor> getBookByFirstName(@PathVariable String firstName) {
        byAuthor author = authorService.getBookByFirstName(firstName);

        if (author != null)   {
            return ResponseEntity.ok(author);
        } else  {
            return ResponseEntity.notFound().build();
        }
    }

    // @GetMapping("getBookByLastName/{lastName}")
    // public ResponseEntity<byAuthor> getBookByLastName(@PathVariable String lastName) {
    //     byAuthor author = authorService.getBookByFirstName(lastName);

    //     if (author != null)   {
    //         return ResponseEntity.ok(author);
    //     } else  {
    //         return ResponseEntity.notFound().build();
    //     }
    // }
    
    @PostMapping("/createAuthor")
    public ResponseEntity<String> createAuthor(@RequestBody AuthorRequestDTO authorRequestDTO)    {
       byAuthor newAuthor = convertToByAuthor(authorRequestDTO);
        authorService.createAuthor(newAuthor);

        return ResponseEntity.ok("Successfully created an Author");
    }

    private byAuthor convertToByAuthor(AuthorRequestDTO authorRequestDTO)  {
        byAuthor newAuthor = new byAuthor();
        newAuthor.setFirstName(authorRequestDTO.getFirstName());
        newAuthor.setLastName(authorRequestDTO.getLastName());
        newAuthor.setBiography(authorRequestDTO.getBiography());
        newAuthor.setPublisher(authorRequestDTO.getPublisher());
  

        return newAuthor;

    }
}
