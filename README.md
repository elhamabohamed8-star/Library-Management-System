# Library Management System

A console-based Library Management System developed in Java using Object-Oriented Programming (OOP). The application allows librarians to manage books, members, and borrowing operations while storing all data in text files to preserve records between program executions.

---

## Features

### Book Management
- Add new books.
- Remove books by ID.
- Search books by ID.
- Search books by title.
- Display all books.
- Track book availability.

### Member Management
- Register new members.
- Remove members by ID.
- Search members by ID.
- Search members by name.
- Display all registered members.
- Track the number of borrowed books for each member.

### Borrowing Management
- Borrow available books.
- Return borrowed books.
- Automatically update book availability.
- Automatically update each member's borrowed book count.
- Store every borrowing operation as a borrowing record.
- Record borrow date, due date, and return date.

### Data Management
- Load all data automatically when the program starts.
- Save books, members, and borrowing records to text files.
- Display the location of the data files.

---

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections (`ArrayList`)
- File Handling
- Exception Handling
- LocalDate API

---

## Project Structure

```
Library-Management-System
│
├── .gitignore
├── Book.java
├── BookService.java
├── BorrowRecord.java
├── BorrowService.java
├── FileManager.java
├── Library.java
├── Main.java
├── Member.java
├── MemberService.java
├── README.md
├── books.txt
├── borrowRecords.txt
└── members.txt
```

---

## Class Description

### Main.java
The application's entry point. It loads saved data, displays the console menus, receives user input, and coordinates all system operations.

### Library.java
Maintains the application's collections of books, members, and borrowing records. It provides methods for managing the stored data.

### Book.java
Represents a book in the library. Each book contains:
- Book ID
- Title
- Author
- Category
- Publisher
- Publication Year
- ISBN
- Availability Status

### Member.java
Represents a library member with:
- Member ID
- Full Name
- Phone Number
- Email
- Address
- Borrowed Books Counter

It also controls whether a member is allowed to borrow additional books.

### BorrowRecord.java
Represents a borrowing transaction containing:
- Record ID
- Member ID
- Book ID
- Borrow Date
- Due Date
- Return Date
- Return Status

### BookService.java
Handles all operations related to books, including:
- Add Book
- Remove Book
- Search by ID
- Search by Title
- Display Books

### MemberService.java
Handles all operations related to members, including:
- Add Member
- Remove Member
- Search by ID
- Search by Name
- Display Members

### BorrowService.java
Handles borrowing operations by:
- Validating the member and book.
- Checking borrowing eligibility.
- Creating borrowing records.
- Updating book availability.
- Returning books.
- Updating borrowing records after return.

### FileManager.java
Responsible for:
- Loading books from **books.txt**
- Loading members from **members.txt**
- Loading borrowing records from **borrowRecords.txt**
- Saving all data back to the corresponding files
- Managing the application's data directory

---

## Data Storage

The application stores data using plain text files.

| File | Purpose |
|------|---------|
| books.txt | Stores all book information |
| members.txt | Stores all registered members |
| borrowRecords.txt | Stores borrowing records |

All data is automatically loaded when the application starts and can be saved for future sessions.

---

## How to Run

1. Clone the repository.
2. Open the project in NetBeans or any Java IDE.
3. Build the project.
4. Run **Main.java**.
5. Use the console menus to manage books, members, and borrowing operations.

---

## Author

**Elham Mosaad**

Computer Science & Data Science Student
