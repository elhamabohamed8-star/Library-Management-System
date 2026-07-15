/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication138;

/**
 *
 * @author YAHOO COMPUTER
 */
import java.util.ArrayList;

public class BookService {

    private Library library;

    public BookService(Library library) {
        this.library = library;
    }

    // Add Book
    public boolean addBook(Book book) {

        for (Book b : library.getBooks()) {
            if (b.getBookId().equalsIgnoreCase(book.getBookId())) {
                return false; // Book already exists
            }
        }

        library.getBooks().add(book);
        return true;
    }

    // Remove Book
    public boolean removeBook(String id) {

        for (Book b : library.getBooks()) {

            if (b.getBookId().equalsIgnoreCase(id)) {
                library.getBooks().remove(b);
                return true;
            }
        }

        return false;
    }

    // Search by ID
    public Book searchById(String id) {

        for (Book b : library.getBooks()) {

            if (b.getBookId().equalsIgnoreCase(id)) {
                return b;
            }
        }

        return null;
    }

    // Search by Title
    public ArrayList<Book> searchByTitle(String title) {

        ArrayList<Book> result = new ArrayList<>();

        for (Book b : library.getBooks()) {

            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(b);
            }
        }

        return result;
    }

    // Display Books
    public void displayBooks() {

        if (library.getBooks().isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        for (Book b : library.getBooks()) {
            b.displayBook();
        }
    }

    // Borrow Book
    public boolean borrowBook(String id) {

        Book book = searchById(id);

        if (book == null)
            return false;

        if (!book.isAvailable())
            return false;

        book.setAvailable(false);
        return true;
    }

    // Return Book
    public boolean returnBook(String id) {

        Book book = searchById(id);

        if (book == null)
            return false;

        if (book.isAvailable())
            return false;

        book.setAvailable(true);
        return true;
    }

    
}
