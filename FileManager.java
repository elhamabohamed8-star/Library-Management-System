
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileManager {

    private static  String BOOK_FILE = "books.txt";
    private static  String MEMBER_FILE = "members.txt";
    private static  String RECORD_FILE = "borrowRecords.txt";

    
    public static String getDataFolderPath() {
        return new File(BOOK_FILE).getAbsoluteFile().getParent();
    }

    public static boolean dataFilesExist() {
        return new File(BOOK_FILE).exists();
    }

    // ===============================
    // Save Books
    // ===============================
    public static void saveBooks(ArrayList<Book> books) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOK_FILE))) {

            for (Book book : books) {
                writer.write(book.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving books.");
        }

    }

    // ===============================
    // Load Books
    // ===============================
    public static ArrayList<Book> loadBooks() {

        ArrayList<Book> books = new ArrayList<>();

        File file = new File(BOOK_FILE);

        if (!file.exists()) {
            return books;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Book book = new Book(
                        data[0],                     // Book ID
                        data[1],                     // Title
                        data[2],                     // Author
                        data[3],                     // Category
                        data[4],                     // Publisher
                        Integer.parseInt(data[5]),   // Publication Year
                        data[6],                     // ISBN
                        Boolean.parseBoolean(data[7])// Available
                );

                books.add(book);
            }

        } catch (IOException e) {
            System.out.println("Error loading books.");
        }

        return books;
    }
    // ===============================
    // Save Members
    // ===============================
    public static void saveMembers(ArrayList<Member> members) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBER_FILE))) {

            for (Member member : members) {
                writer.write(member.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving members.");
        }

    }

    // ===============================
    // Load Members
    // ===============================
    public static ArrayList<Member> loadMembers() {

        ArrayList<Member> members = new ArrayList<>();

        File file = new File(MEMBER_FILE);

        if (!file.exists()) {
            return members;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Member member = new Member(
                        data[0],                   // Member ID
                        data[1],                   // Full Name
                        data[2],                   // Phone Number
                        data[3],                   // Email
                        data[4],                   // Address
                        Integer.parseInt(data[5])  // Borrowed Books Count
                );

                members.add(member);
            }

        } catch (IOException e) {
            System.out.println("Error loading members.");
        }

        return members;
    }
        // ===============================
    // Save Borrow Records
    // ===============================
    public static void saveBorrowRecords(ArrayList<BorrowRecord> records) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RECORD_FILE))) {

            for (BorrowRecord record : records) {
                writer.write(record.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving borrow records.");
        }

    }

    // ===============================
    // Load Borrow Records
    // ===============================
    public static ArrayList<BorrowRecord> loadBorrowRecords() {

        ArrayList<BorrowRecord> records = new ArrayList<>();

        File file = new File(RECORD_FILE);

        if (!file.exists()) {
            return records;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                BorrowRecord record = new BorrowRecord(
                        data[0],                           // Record ID
                        data[1],                           // Member ID
                        data[2],                           // Book ID
                        LocalDate.parse(data[3]),          // Borrow Date
                        LocalDate.parse(data[4]),          // Due Date
                        data[5].equals("null") ? null : LocalDate.parse(data[5]),
                        Boolean.parseBoolean(data[6])      // Returned
                );

                records.add(record);
            }

        } catch (IOException e) {
            System.out.println("Error loading borrow records.");
        }

        return records;
    }

}
