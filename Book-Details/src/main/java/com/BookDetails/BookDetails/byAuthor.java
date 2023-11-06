package com.BookDetails.BookDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class byAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    private String biography;
    private String publisher;

     
    public Long getId() {
        return id;
    }
       public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getBiography() {
        return biography;
    }
     public String getPublisher() {
        return publisher;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
     public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
     public void setBiography(String biography) {
        this.biography = biography;
    }
      public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
