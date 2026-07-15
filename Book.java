/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication138;

/**
 *
 * @author YAHOO COMPUTER
 */
public class Book {
    private String bookId;
    private String title;
    private String author;
    private String category;
    private String publisher;
    private int publicationYear;
    private String isbn;
    private boolean available;

    // Default Constructor
    public Book() {

    }

    // Parameterized Constructor
    public Book(String bookId, String title, String author,
                String category, String publisher,
                int publicationYear, String isbn,
                boolean available) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.available = available;
    }

    // ================= Getters =================

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    // ================= Setters =================

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // ================= Business Methods =================

    public void borrowBook() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }

    public void displayBook() {

        System.out.println("--------------------------------------------");
        System.out.println("Book ID          : " + bookId);
        System.out.println("Title            : " + title);
        System.out.println("Author           : " + author);
        System.out.println("Category         : " + category);
        System.out.println("Publisher        : " + publisher);
        System.out.println("Publication Year : " + publicationYear);
        System.out.println("ISBN             : " + isbn);
        System.out.println("Status           : "
                + (available ? "Available" : "Borrowed"));
        System.out.println("--------------------------------------------");

    }

    // Used for saving data to file
    @Override
    public String toString() {

        return bookId + ","
                + title + ","
                + author + ","
                + category + ","
                + publisher + ","
                + publicationYear + ","
                + isbn + ","
                + available;

    }
}
