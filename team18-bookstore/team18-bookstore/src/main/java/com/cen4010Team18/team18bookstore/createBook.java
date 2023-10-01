package com.cen4010Team18.team18bookstore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class createBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String isbn;
    @NotBlank(message = "Book name is required")
    private String bookName;
    private String bookDescription;
    private double price;
    private String author;
    private String genre;
    private String publisher;
    private int yearPublished;
    private int copiesSold;


    public String getIsbn() {
        return isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public String getbookDescription() {
        return bookDescription;
    }

    public double getprice() {
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

    public void setIsbn(String isbn)    {
        this.isbn = isbn;
    }

    public void setBookName(String bookName)    {
        this.bookName = bookName;
    }

    public void setBookDescription(String bookDescription)    {
        this.bookDescription = bookDescription;
    }

    public void setPrice(double price) {
        if (price >= 0) {
        this.price = price;
        } else {
            throw new IllegalArgumentException("The price cannot be negative");
        }
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
          if (copiesSold >= 0) {
        this.copiesSold = copiesSold;
        } else {
            throw new IllegalArgumentException("The copies sold cannot be negative");
        }
    }


}
