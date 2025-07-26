import java.io.*;
import java.util.*;

public class LibraryManager {
    private static final String FILE_NAME = "data.ser";

    public static void addBook(Scanner sc) {
        ArrayList<Book> books = readBooks();
        Book newBook = new Book();
        newBook.accept(sc);

        // Check for duplicate ID
        for (Book b : books) {
            if (b.getBookId() == newBook.getBookId()) {
                System.out.println("\nDuplicate book ID! Cannot add.");
                return;
            }
        }

        books.add(newBook);
        writeBooks(books);
        System.out.println("Book added successfully.");
    }

    public static void viewAll() {
        ArrayList<Book> books = readBooks();
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        printHeader();
        for (Book b : books) {
            b.display();
        }
    }

    public static void searchById(Scanner sc) {
        System.out.print("Enter book ID: ");
        int id = sc.nextInt();
        ArrayList<Book> books = readBooks();
        boolean found = false;
        for (Book b : books) {
            if (b.getBookId() == id) {
                printHeader();
                b.display();
                found = true;
            }
        }
        if (!found) System.out.println("Book not found.");
    }

    public static void searchByName(Scanner sc) {
        System.out.print("Enter book name: ");
        sc.nextLine();
        String name = sc.nextLine();
        ArrayList<Book> books = readBooks();
        boolean found = false;
        for (Book b : books) {
            if (b.getBookName().equalsIgnoreCase(name)) {
                printHeader();
                b.display();
                found = true;
            }
        }
        if (!found) System.out.println("Book not found.");
    }

    public static void searchByAuthor(Scanner sc) {
        System.out.print("Enter author name: ");
        sc.nextLine();
        String name = sc.nextLine();
        ArrayList<Book> books = readBooks();
        boolean found = false;
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(name)) {
                printHeader();
                b.display();
                found = true;
            }
        }
        if (!found) System.out.println("Author not found.");
    }

    public static void searchByPublisher(Scanner sc) {
        System.out.print("Enter publisher: ");
        sc.nextLine();
        String pub = sc.nextLine();
        ArrayList<Book> books = readBooks();
        boolean found = false;
        for (Book b : books) {
            if (b.getPublisher().equalsIgnoreCase(pub)) {
                printHeader();
                b.display();
                found = true;
            }
        }
        if (!found) System.out.println("Publisher not found.");
    }

    public static void searchByIsbn(Scanner sc) {
        System.out.print("Enter ISBN: ");
        sc.nextLine();
        String isbn = sc.nextLine();
        ArrayList<Book> books = readBooks();
        boolean found = false;
        for (Book b : books) {
            if (b.getIsbn().equalsIgnoreCase(isbn)) {
                printHeader();
                b.display();
                found = true;
            }
        }
        if (!found) System.out.println("ISBN not found.");
    }

    public static void removeBook(Scanner sc) {
        System.out.print("Enter book ID to remove: ");
        int id = sc.nextInt();
        ArrayList<Book> books = readBooks();
        boolean removed = books.removeIf(book -> book.getBookId() == id);
        writeBooks(books);
        if (removed)
            System.out.println("Book removed successfully.");
        else
            System.out.println("Book ID not found.");
    }

    public static void issueBook(Scanner sc) {
        System.out.print("Enter membership ID: ");
        int memberId = sc.nextInt();
        System.out.print("Enter book ID to issue: ");
        int bookId = sc.nextInt();

        ArrayList<Book> books = readBooks();
        boolean updated = false;

        for (Book b : books) {
            if (b.getBookId() == bookId) {
                if (b.getIssuedTo() == 0) {
                    b.setIssuedTo(memberId);
                    updated = true;
                    System.out.println("Book issued.");
                } else {
                    System.out.println("Book is already issued.");
                }
                break;
            }
        }

        if (updated) writeBooks(books);
    }

    public static void returnBook(Scanner sc) {
        System.out.print("Enter book ID to return: ");
        int bookId = sc.nextInt();
        System.out.print("Enter membership ID: ");
        int memberId = sc.nextInt();

        ArrayList<Book> books = readBooks();
        boolean updated = false;

        for (Book b : books) {
            if (b.getBookId() == bookId) {
                if (b.getIssuedTo() == memberId) {
                    b.setIssuedTo(0);
                    updated = true;
                    System.out.println("Book returned.");
                } else {
                    System.out.println("Incorrect membership ID.");
                }
                break;
            }
        }

        if (updated) writeBooks(books);
    }

    // Helper methods
    @SuppressWarnings("unchecked")
    private static ArrayList<Book> readBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Book>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private static void writeBooks(ArrayList<Book> books) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    private static void printHeader() {
        System.out.printf("%10s%35s%35s%10s%35s%10s%10s%n",
                "Book ID", "Book Name", "Author", "Edition", "Publisher", "ISBN", "IssuedTo");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
    }
}
