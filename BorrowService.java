
import java.time.LocalDate;

public class BorrowService {

    private Library library;

    public BorrowService(Library library) {
        this.library = library;
    }

    // ===============================
    // Borrow Book
    // ===============================
    public boolean borrowBook(String memberId, String bookId) {

        Member member = null;
        Book book = null;

        for (Member m : library.getMembers()) {
            if (m.getMemberId().equalsIgnoreCase(memberId)) {
                member = m;
                break;
            }
        }

        for (Book b : library.getBooks()) {
            if (b.getBookId().equalsIgnoreCase(bookId)) {
                book = b;
                break;
            }
        }

        if (member == null || book == null)
            return false;

        if (!member.canBorrow())
            return false;

        if (!book.isAvailable())
            return false;

        member.borrowBook();
        book.borrowBook();

        String recordId = "R" + (library.getBorrowRecords().size() + 1);

        BorrowRecord record = new BorrowRecord(
                recordId,
                memberId,
                bookId,
                LocalDate.now(),
                LocalDate.now().plusDays(14),
                null,
                false
        );

        library.addBorrowRecord(record);

        return true;
    }

    // ===============================
    // Return Book
    // ===============================
    public boolean returnBook(String recordId) {

        BorrowRecord record = null;

        for (BorrowRecord r : library.getBorrowRecords()) {

            if (r.getRecordId().equalsIgnoreCase(recordId)) {
                record = r;
                break;
            }

        }

        if (record == null)
            return false;

        if (record.isReturned())
            return false;

        record.returnBook();

        for (Book b : library.getBooks()) {

            if (b.getBookId().equals(record.getBookId())) {
                b.returnBook();
                break;
            }

        }

        for (Member m : library.getMembers()) {

            if (m.getMemberId().equals(record.getMemberId())) {
                m.returnBook();
                break;
            }

        }

        return true;
    }


}
