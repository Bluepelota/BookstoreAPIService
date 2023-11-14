package com.BookDetails.BookDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class bookDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String isbn;
    private String bookName;
    private String bookDescription;
    private Double price; 
    private String author;
    private String genre;
    private String publisher;
    private Integer yearPublished;
    private Integer copiesSold;



    public String getIsbn() {
        return isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

     public Double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

     public String getPublisher() {
        return publisher;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

     public Integer getCopiesSold() {
        return copiesSold;
    }
   

    

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

     public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

     public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

     public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

     public void setCopiesSold(Integer copiesSold) {
        this.copiesSold = copiesSold;
    }
}
