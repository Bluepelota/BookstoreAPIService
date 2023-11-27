package com.BookDetails.BookDetails;

public class AuthorRequestDTO {
    
    private String firstName;
    private String lastName;
    private String biography;
    private String publisher;
    
    
    
        public AuthorRequestDTO() {
            
        }
    
        public AuthorRequestDTO(String firstName, String lastName, String biography, String publisher)    {
            this.firstName = firstName;
            this.lastName = lastName;
            this.biography = biography;
            this.publisher = publisher;
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
