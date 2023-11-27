package com.BookDetails.BookDetails;

public class BookRequestDTO {
    private String isbn;
    private String bookName;
    private String bookDescription;
    private double price; 
    private String author; 
    private String genre;
    private String publisher;
    private int yearPublished;
    private int copiesSold;
    private Long authorId;


    public BookRequestDTO() {
        
    }

    public BookRequestDTO(String isbn, String bookName, String bookDescription, double price, String author, String genre, String publisher, int yearPublished, int copiesSold, Long authorId) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.price = price;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
        this.authorId = authorId;
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
    public Long getAuthorId()   {
        return authorId;
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
    public void setAuthorId(Long authorId)  {
        this.authorId = authorId;
    }


}
