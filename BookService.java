
import java.util.ArrayList;

public class BookService {

    private Library library;

    public BookService(Library library) {
        this.library = library;
    }

    public boolean addBook(Book book) {

        for (Book b : library.getBooks()) {
            if (b.getBookId().equalsIgnoreCase(book.getBookId())) {
                return false; // Book already exists
            }
        }

        library.getBooks().add(book);
        return true;
    }

    public boolean removeBook(String id) {

        for (Book b : library.getBooks()) {

            if (b.getBookId().equalsIgnoreCase(id)) {
                library.getBooks().remove(b);
                return true;
            }
        }

        return false;
    }

    public Book searchById(String id) {

        for (Book b : library.getBooks()) {

            if (b.getBookId().equalsIgnoreCase(id)) {
                return b;
            }
        }

        return null;
    }

    public ArrayList<Book> searchByTitle(String title) {

        ArrayList<Book> result = new ArrayList<>();

        for (Book b : library.getBooks()) {

            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(b);
            }
        }

        return result;
    }

    public void displayBooks() {

        if (library.getBooks().isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        for (Book b : library.getBooks()) {
            b.displayBook();
        }
    }

    public boolean borrowBook(String id) {

        Book book = searchById(id);

        if (book == null)
            return false;

        if (!book.isAvailable())
            return false;

        book.setAvailable(false);
        return true;
    }

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
