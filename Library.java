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

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private ArrayList<BorrowRecord> borrowRecords;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        borrowRecords = new ArrayList<>();
    }

    // ===========================
    // Getters
    // ===========================

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<BorrowRecord> getBorrowRecords() {
        return borrowRecords;
    }
    //============================
    // Setters
    //===========================

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void setBorrowRecords(ArrayList<BorrowRecord> borrowRecords) {
        this.borrowRecords = borrowRecords;
    }
    
    // ===========================
    // Book Methods
    // ===========================

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    // ===========================
    // Member Methods
    // ===========================

    public void addMember(Member member) {
        members.add(member);
    }

    public boolean removeMember(Member member) {
        return members.remove(member);
    }

    // ===========================
    // Borrow Record Methods
    // ===========================

    public void addBorrowRecord(BorrowRecord record) {
        borrowRecords.add(record);
    }

    public boolean removeBorrowRecord(BorrowRecord record) {
        return borrowRecords.remove(record);
    
}   
}
