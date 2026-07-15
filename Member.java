/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication138;

/**
 *
 * @author YAHOO COMPUTER
 */
public class Member {

    private String memberId;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;
    private int borrowedBooksCount;

    // Default Constructor
    public Member() {

    }

    // Parameterized Constructor
    public Member(String memberId, String fullName, String phoneNumber,
                  String email, String address, int borrowedBooksCount) {

        this.memberId = memberId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.borrowedBooksCount = borrowedBooksCount;
    }

    // ================= Getters =================

    public String getMemberId() {
        return memberId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getBorrowedBooksCount() {
        return borrowedBooksCount;
    }

    // ================= Setters =================

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBorrowedBooksCount(int borrowedBooksCount) {
        this.borrowedBooksCount = borrowedBooksCount;
    }

    // ================= Business Methods =================

    public boolean canBorrow() {
        return borrowedBooksCount < 3;
    }

    public void borrowBook() {
        borrowedBooksCount++;
    }

    public void returnBook() {

        if (borrowedBooksCount > 0) {
            borrowedBooksCount--;
        }

    }

    public void displayMember() {

        System.out.println("--------------------------------------------");
        System.out.println("Member ID      : " + memberId);
        System.out.println("Full Name      : " + fullName);
        System.out.println("Phone Number   : " + phoneNumber);
        System.out.println("Email          : " + email);
        System.out.println("Address        : " + address);
        System.out.println("Borrowed Books : " + borrowedBooksCount);
        System.out.println("--------------------------------------------");

    }

    // Used for saving data to file
    @Override
    public String toString() {

        return memberId + ","
                + fullName + ","
                + phoneNumber + ","
                + email + ","
                + address + ","
                + borrowedBooksCount;

    }

    
}
