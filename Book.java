import java.io.Serializable;

public class Book implements Serializable {
    private int bookId;
    private String bookName;
    private String author;
    private int edition;
    private String publisher;
    private String isbn;
    private int issuedTo = 0;

    public void accept(java.util.Scanner sc) {
        System.out.print("Enter book ID: ");
        bookId = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Book name: ");
        bookName = sc.nextLine();
        System.out.print("Enter Author name: ");
        author = sc.nextLine();
        System.out.print("Enter Edition: ");
        edition = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Publisher: ");
        publisher = sc.nextLine();
        System.out.print("Enter ISBN: ");
        isbn = sc.nextLine();
    }

    public void display() {
        System.out.printf("%10d%35s%35s%10d%35s%10s%10d%n",
                bookId, bookName, author, edition, publisher, isbn, issuedTo);
    }

    // Getters and Setters
    public int getBookId() { return bookId; }
    public String getBookName() { return bookName; }
    public String getAuthor() { return author; }
    public int getEdition() { return edition; }
    public String getPublisher() { return publisher; }
    public String getIsbn() { return isbn; }
    public int getIssuedTo() { return issuedTo; }

    public void setIssuedTo(int id) {
        issuedTo = id;
    }
}
