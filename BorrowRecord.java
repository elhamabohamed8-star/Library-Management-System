
import java.time.LocalDate;

public class BorrowRecord {


    private String recordId;
    private String memberId;
    private String bookId;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private boolean returned;

    public BorrowRecord() {

    }

    public BorrowRecord(String recordId, String memberId, String bookId,
                        LocalDate borrowDate, LocalDate dueDate,
                        LocalDate returnDate, boolean returned) {

        this.recordId = recordId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.returned = returned;
    }

    // ================= Getters =================

    public String getRecordId() {
        return recordId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getBookId() {
        return bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    // ================= Setters =================

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    // ================= Business Methods =================

    public void returnBook() {
        this.returned = true;
        this.returnDate = LocalDate.now();
    }

    public boolean isOverdue() {

        return !returned && LocalDate.now().isAfter(dueDate);

    }

    public void displayRecord() {

        System.out.println("--------------------------------------------");
        System.out.println("Record ID     : " + recordId);
        System.out.println("Member ID     : " + memberId);
        System.out.println("Book ID       : " + bookId);
        System.out.println("Borrow Date   : " + borrowDate);
        System.out.println("Due Date      : " + dueDate);
        System.out.println("Return Date   : "
                + (returnDate == null ? "Not Returned" : returnDate));
        System.out.println("Status        : "
                + (returned ? "Returned" : "Borrowed"));
        System.out.println("--------------------------------------------");

    }

    @Override
    public String toString() {

        return recordId + ","
                + memberId + ","
                + bookId + ","
                + borrowDate + ","
                + dueDate + ","
                + (returnDate == null ? "null" : returnDate) + ","
                + returned;

    }

    
}
