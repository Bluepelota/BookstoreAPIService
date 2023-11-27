package com.BookDetails.BookDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class byAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String biography;
    private String publisher;

    @PrePersist
    public void prePersist()    {
        if(firstName == null)   {
            firstName = "N/A";
        }
        if(lastName == null)   {
            lastName = "N/A";
        }
        if(biography == null)   {
            biography = "N/A";
        }
        if(publisher == null)   {
            publisher = "N/A";
        }
    }

     
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
