package com.BookDetails.BookDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class bookDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String bookName;
    private String bookDescription;
    private double price; 
    private String author;
    private String genre;
    private String publisher;
    private int yearPublished;
    private int copiesSold;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private byAuthor bookAuthor;

    @PrePersist
    public void prePersist()    {
        if (isbn == null || isbn.isEmpty())   {
            isbn = "N/A";
        }
        if (bookName == null)   {
            bookName = "N/A";
        }
        if (bookDescription == null)   {
            bookDescription = "N/A";
        }
        if (price < 0.0)   {
            price = 0.0;
        }
       if (author == null)   {
           author = "N/A";
       }
        if (genre == null)   {
            genre = "N/A";
        }
        if (publisher == null)   {
            publisher = "N/A";
        }
        if (yearPublished < 0)   {
            yearPublished = 0;
        }
        if (copiesSold < 0)   {
            copiesSold = 0;
        }

    }


    public String getIsbn() {
        return isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

     public double getPrice() {
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

    public int getYearPublished() {
        return yearPublished;
    }

     public int getCopiesSold() {
        return copiesSold;
    }

    public byAuthor geAuthor()  {
        return bookAuthor;
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

    public void setPrice(double price) {
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

     public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

     public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public void setAuthor(byAuthor bookAuthor)   {
        this.bookAuthor = bookAuthor;
    }
}
