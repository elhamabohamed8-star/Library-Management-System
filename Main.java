/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication138;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Library Management System - Console Application.
 *
 * @author YAHOO COMPUTER
 */
public class JavaApplication138 {

    static Scanner input = new Scanner(System.in);
    static Library library = new Library();
    static BookService bookService = new BookService(library);
    static MemberService memberService = new MemberService(library);
    static BorrowService borrowService = new BorrowService(library);

    public static void main(String[] args) {

        library.setBooks(FileManager.loadBooks());
        library.setMembers(FileManager.loadMembers());
        library.setBorrowRecords(FileManager.loadBorrowRecords());

        printWelcomeBanner();

        int choice = -1;

        while (choice != 8) {

            printMainMenu();
            choice = readInt("Choose: ");

            switch (choice) {

                case 1:
                    bookMenu();
                    break;

                case 2:
                    memberMenu();
                    break;

                case 3:
                    borrowBookMenu();
                    pause();
                    break;

                case 4:
                    returnBookMenu();
                    pause();
                    break;

                case 5:
                    searchMenu();
                    break;

                case 6:
                    reportsMenu();
                    break;

                case 7:
                    saveAll();
                    printSuccess("Data saved successfully.");
                    pause();
                    break;

                case 8:
                    saveAll();
                    printGoodbyeBanner();
                    break;

                default:
                    printError("Invalid choice. Please select a number between 1 and 8.");
                    pause();
            }
        }

        input.close();
    }

    // =====================================================
    // Banners & Menus
    // =====================================================
    private static void printWelcomeBanner() {
        System.out.println("\n" + line('=', 50));
        System.out.println(center("LIBRARY MANAGEMENT SYSTEM", 50));
        System.out.println(line('=', 50));
        System.out.println(center("Loaded " + library.getBooks().size() + " books, "
                + library.getMembers().size() + " members, "
                + library.getBorrowRecords().size() + " borrow records", 50));
        System.out.println(line('=', 50));
    }

    private static void printGoodbyeBanner() {
        System.out.println("\n" + line('=', 50));
        System.out.println(center("Thank you for using the system. Goodbye!", 50));
        System.out.println(line('=', 50));
    }

    private static void printMainMenu() {
        System.out.println("\n" + line('-', 50));
        System.out.println(center("MAIN MENU", 50));
        System.out.println(line('-', 50));
        System.out.println("  1. Book Management");
        System.out.println("  2. Member Management");
        System.out.println("  3. Borrow Book");
        System.out.println("  4. Return Book");
        System.out.println("  5. Search");
        System.out.println("  6. Reports");
        System.out.println("  7. Save Data");
        System.out.println("  8. Exit");
        System.out.println(line('-', 50));
    }

    // =====================================================
    // Book Management Menu
    // =====================================================
    private static void bookMenu() {

        int choice = -1;

        while (choice != 5) {

            System.out.println("\n" + line('-', 50));
            System.out.println(center("BOOK MANAGEMENT", 50));
            System.out.println(line('-', 50));
            System.out.println("  1. Add Book");
            System.out.println("  2. Remove Book");
            System.out.println("  3. Search Book by ID");
            System.out.println("  4. Display All Books");
            System.out.println("  5. Back to Main Menu");
            System.out.println(line('-', 50));

            choice = readInt("Choose: ");

            switch (choice) {

                case 1:
                    addBook();
                    pause();
                    break;

                case 2:
                    removeBookFlow();
                    pause();
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    String searchId = readNonEmpty();
                    Book found = bookService.searchById(searchId);

                    if (found != null)
                        found.displayBook();
                    else
                        printError("Book not found.");

                    pause();
                    break;

                case 4:
                    printBooksTable(library.getBooks());
                    pause();
                    break;

                case 5:
                    // Back to main menu
                    break;

                default:
                    printError("Invalid choice.");
                    pause();
            }
        }
    }

    private static void addBook() {

        System.out.println("\n-- Add New Book --");

        System.out.print("Book ID: ");
        String bookId = readNonEmpty();

        if (bookService.searchById(bookId) != null) {
            printError("A book with this ID already exists.");
            return;
        }

        System.out.print("Title: ");
        String title = readNonEmpty();

        System.out.print("Author: ");
        String author = readNonEmpty();

        System.out.print("Category: ");
        String category = readNonEmpty();

        System.out.print("Publisher: ");
        String publisher = readNonEmpty();

        int year = readIntInRange("Publication Year (1450-2100): ", 1450, 2100);

        System.out.print("ISBN: ");
        String isbn = readNonEmpty();

        Book book = new Book(bookId, title, author, category, publisher, year, isbn, true);

        if (bookService.addBook(book))
            printSuccess("Book added successfully.");
        else
            printError("Book already exists.");
    }

    private static void removeBookFlow() {

        System.out.print("Enter Book ID to remove: ");
        String removeId = readNonEmpty();

        Book book = bookService.searchById(removeId);

        if (book == null) {
            printError("Book not found.");
            return;
        }

        book.displayBook();

        if (confirm("Are you sure you want to remove this book? (y/n): ")) {

            if (bookService.removeBook(removeId))
                printSuccess("Book removed successfully.");
            else
                printError("Book could not be removed.");

        } else {
            System.out.println("Cancelled.");
        }
    }

    // =====================================================
    // Member Management Menu
    // =====================================================
    private static void memberMenu() {

        int choice = -1;

        while (choice != 5) {

            System.out.println("\n" + line('-', 50));
            System.out.println(center("MEMBER MANAGEMENT", 50));
            System.out.println(line('-', 50));
            System.out.println("  1. Add Member");
            System.out.println("  2. Remove Member");
            System.out.println("  3. Search Member by ID");
            System.out.println("  4. Display All Members");
            System.out.println("  5. Back to Main Menu");
            System.out.println(line('-', 50));

            choice = readInt("Choose: ");

            switch (choice) {

                case 1:
                    addMember();
                    pause();
                    break;

                case 2:
                    removeMemberFlow();
                    pause();
                    break;

                case 3:
                    System.out.print("Enter Member ID: ");
                    String searchId = readNonEmpty();
                    Member found = memberService.searchById(searchId);

                    if (found != null)
                        found.displayMember();
                    else
                        printError("Member not found.");

                    pause();
                    break;

                case 4:
                    printMembersTable(library.getMembers());
                    pause();
                    break;

                case 5:
                    // Back to main menu
                    break;

                default:
                    printError("Invalid choice.");
                    pause();
            }
        }
    }

    private static void addMember() {

        System.out.println("\n-- Add New Member --");

        System.out.print("Member ID: ");
        String memberId = readNonEmpty();

        if (memberService.searchById(memberId) != null) {
            printError("A member with this ID already exists.");
            return;
        }

        System.out.print("Full Name: ");
        String fullName = readNonEmpty();

        System.out.print("Phone Number: ");
        String phone = readNonEmpty();

        System.out.print("Email: ");
        String email = readNonEmpty();

        System.out.print("Address: ");
        String address = readNonEmpty();

        Member member = new Member(memberId, fullName, phone, email, address, 0);

        if (memberService.addMember(member))
            printSuccess("Member added successfully.");
        else
            printError("Member already exists.");
    }

    private static void removeMemberFlow() {

        System.out.print("Enter Member ID to remove: ");
        String removeId = readNonEmpty();

        Member member = memberService.searchById(removeId);

        if (member == null) {
            printError("Member not found.");
            return;
        }

        member.displayMember();

        if (member.getBorrowedBooksCount() > 0) {
            printError("This member still has borrowed books and cannot be removed.");
            return;
        }

        if (confirm("Are you sure you want to remove this member? (y/n): ")) {

            if (memberService.removeMember(removeId))
                printSuccess("Member removed successfully.");
            else
                printError("Member could not be removed.");

        } else {
            System.out.println("Cancelled.");
        }
    }

    // =====================================================
    // Borrow / Return
    // =====================================================
    private static void borrowBookMenu() {

        System.out.println("\n-- Borrow Book --");

        System.out.print("Member ID: ");
        String memberId = readNonEmpty();

        System.out.print("Book ID: ");
        String bookId = readNonEmpty();

        if (borrowService.borrowBook(memberId, bookId))
            printSuccess("Book borrowed successfully. Due in 14 days.");
        else
            printError("Borrow operation failed. Check member ID, book ID, "
                    + "book availability, or the member's borrow limit (max 3 books).");
    }

    private static void returnBookMenu() {

        System.out.println("\n-- Return Book --");

        System.out.print("Borrow Record ID: ");
        String recordId = readNonEmpty();

        if (borrowService.returnBook(recordId))
            printSuccess("Book returned successfully.");
        else
            printError("Invalid Record ID or book already returned.");
    }

    // =====================================================
    // Search Menu
    // =====================================================
    private static void searchMenu() {

        int choice = -1;

        while (choice != 3) {

            System.out.println("\n" + line('-', 50));
            System.out.println(center("SEARCH", 50));
            System.out.println(line('-', 50));
            System.out.println("  1. Search Book by Title");
            System.out.println("  2. Search Member by Name");
            System.out.println("  3. Back to Main Menu");
            System.out.println(line('-', 50));

            choice = readInt("Choose: ");

            switch (choice) {

                case 1:
                    System.out.print("Enter Title (or part of it): ");
                    String title = readNonEmpty();
                    ArrayList<Book> books = bookService.searchByTitle(title);
                    printBooksTable(books);
                    pause();
                    break;

                case 2:
                    System.out.print("Enter Name (or part of it): ");
                    String name = readNonEmpty();
                    ArrayList<Member> members = memberService.searchByName(name);
                    printMembersTable(members);
                    pause();
                    break;

                case 3:
                    // Back to main menu
                    break;

                default:
                    printError("Invalid choice.");
                    pause();
            }
        }
    }

    // =====================================================
    // Reports Menu
    // =====================================================
    private static void reportsMenu() {

        int choice = -1;

        while (choice != 6) {

            System.out.println("\n" + line('-', 50));
            System.out.println(center("REPORTS", 50));
            System.out.println(line('-', 50));
            System.out.println("  1. Available Books");
            System.out.println("  2. Borrowed Books");
            System.out.println("  3. Overdue Borrow Records");
            System.out.println("  4. Books Grouped by Category");
            System.out.println("  5. Library Summary");
            System.out.println("  6. Back to Main Menu");
            System.out.println(line('-', 50));

            choice = readInt("Choose: ");

            switch (choice) {

                case 1: {
                    ArrayList<Book> available = new ArrayList<>();
                    for (Book b : library.getBooks())
                        if (b.isAvailable())
                            available.add(b);

                    printBooksTable(available);
                    pause();
                    break;
                }

                case 2: {
                    ArrayList<Book> borrowed = new ArrayList<>();
                    for (Book b : library.getBooks())
                        if (!b.isAvailable())
                            borrowed.add(b);

                    printBooksTable(borrowed);
                    pause();
                    break;
                }

                case 3: {
                    boolean anyOverdue = false;

                    System.out.println("\n" + line('-', 50));
                    System.out.println(center("OVERDUE RECORDS", 50));
                    System.out.println(line('-', 50));

                    for (BorrowRecord r : library.getBorrowRecords()) {
                        if (r.isOverdue()) {
                            r.displayRecord();
                            anyOverdue = true;
                        }
                    }

                    if (!anyOverdue)
                        System.out.println("No overdue records.");

                    pause();
                    break;
                }

                case 4: {
                    printBooksByCategory();
                    pause();
                    break;
                }

                case 5: {
                    printLibrarySummary();
                    pause();
                    break;
                }

                case 6:
                    // Back to main menu
                    break;

                default:
                    printError("Invalid choice.");
                    pause();
            }
        }
    }

    private static void printBooksByCategory() {

        ArrayList<String> categories = new ArrayList<>();

        for (Book b : library.getBooks()) {
            if (!categories.contains(b.getCategory())) {
                categories.add(b.getCategory());
            }
        }

        if (categories.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        for (String category : categories) {

            System.out.println("\n" + line('-', 50));
            System.out.println(center("Category: " + category, 50));
            System.out.println(line('-', 50));

            ArrayList<Book> booksInCategory = new ArrayList<>();

            for (Book b : library.getBooks()) {
                if (b.getCategory().equals(category)) {
                    booksInCategory.add(b);
                }
            }

            printBooksTable(booksInCategory);
        }
    }

    private static void printLibrarySummary() {

        int totalBooks = library.getBooks().size();
        int availableBooks = 0;

        for (Book b : library.getBooks())
            if (b.isAvailable())
                availableBooks++;

        int borrowedBooks = totalBooks - availableBooks;

        int totalMembers = library.getMembers().size();

        int activeBorrows = 0;
        int overdue = 0;

        for (BorrowRecord r : library.getBorrowRecords()) {
            if (!r.isReturned())
                activeBorrows++;
            if (r.isOverdue())
                overdue++;
        }

        System.out.println("\n" + line('=', 50));
        System.out.println(center("LIBRARY SUMMARY", 50));
        System.out.println(line('=', 50));
        System.out.printf("%-30s%10d%n", "Total Books:", totalBooks);
        System.out.printf("%-30s%10d%n", "Available Books:", availableBooks);
        System.out.printf("%-30s%10d%n", "Borrowed Books:", borrowedBooks);
        System.out.printf("%-30s%10d%n", "Total Members:", totalMembers);
        System.out.printf("%-30s%10d%n", "Total Borrow Records:", library.getBorrowRecords().size());
        System.out.printf("%-30s%10d%n", "Active Borrows:", activeBorrows);
        System.out.printf("%-30s%10d%n", "Overdue Records:", overdue);
        System.out.println(line('=', 50));
    }

    // =====================================================
    // Table Printers
    // =====================================================
    private static void printBooksTable(ArrayList<Book> books) {

        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        String format = "%-8s %-25s %-18s %-14s %-10s%n";

        System.out.println();
        System.out.printf(format, "ID", "Title", "Author", "Category", "Status");
        System.out.println(line('-', 78));

        for (Book b : books) {
            System.out.printf(format,
                    truncate(b.getBookId(), 8),
                    truncate(b.getTitle(), 25),
                    truncate(b.getAuthor(), 18),
                    truncate(b.getCategory(), 14),
                    b.isAvailable() ? "Available" : "Borrowed");
        }

        System.out.println(line('-', 78));
        System.out.println("Total: " + books.size() + " book(s)");
    }

    private static void printMembersTable(ArrayList<Member> members) {

        if (members.isEmpty()) {
            System.out.println("No members found.");
            return;
        }

        String format = "%-8s %-20s %-14s %-22s %-9s%n";

        System.out.println();
        System.out.printf(format, "ID", "Name", "Phone", "Email", "Borrowed");
        System.out.println(line('-', 78));

        for (Member m : members) {
            System.out.printf(format,
                    truncate(m.getMemberId(), 8),
                    truncate(m.getFullName(), 20),
                    truncate(m.getPhoneNumber(), 14),
                    truncate(m.getEmail(), 22),
                    m.getBorrowedBooksCount() + "/3");
        }

        System.out.println(line('-', 78));
        System.out.println("Total: " + members.size() + " member(s)");
    }

    // =====================================================
    // Helpers
    // =====================================================
    private static void saveAll() {
        FileManager.saveBooks(library.getBooks());
        FileManager.saveMembers(library.getMembers());
        FileManager.saveBorrowRecords(library.getBorrowRecords());
    }

    // Reads an integer safely, re-prompting on invalid input
    private static int readInt(String prompt) {

        System.out.print(prompt);

        while (!input.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            input.next();
        }

        int value = input.nextInt();
        input.nextLine(); // consume newline
        return value;
    }

    // Reads an integer and enforces it falls within [min, max]
    private static int readIntInRange(String prompt, int min, int max) {

        int value;

        while (true) {
            value = readInt(prompt);

            if (value < min || value > max)
                System.out.println("Please enter a value between " + min + " and " + max + ".");
            else
                break;
        }

        return value;
    }

    // Reads a non-empty line of text, re-prompting if left blank
    private static String readNonEmpty() {

        String value = input.nextLine().trim();

        while (value.isEmpty()) {
            System.out.print("This field cannot be empty. Please enter a value: ");
            value = input.nextLine().trim();
        }

        return value;
    }

    // Simple yes/no confirmation prompt
    private static boolean confirm(String prompt) {

        System.out.print(prompt);
        String answer = input.nextLine().trim().toLowerCase();

        return answer.equals("y") || answer.equals("yes");
    }

    // Pauses execution until the user presses Enter
    private static void pause() {
        System.out.print("\nPress Enter to continue...");
        input.nextLine();
    }

    private static void printSuccess(String message) {
        System.out.println("[OK] " + message);
    }

    private static void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    private static String truncate(String text, int maxLength) {

        if (text == null)
            return "";

        if (text.length() <= maxLength)
            return text;

        return text.substring(0, maxLength - 3) + "...";
    }

    private static String line(char c, int length) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++)
            sb.append(c);

        return sb.toString();
    }

    private static String center(String text, int width) {

        if (text.length() >= width)
            return text;

        int padding = (width - text.length()) / 2;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < padding; i++)
            sb.append(' ');

        sb.append(text);

        return sb.toString();
    }
}
