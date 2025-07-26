import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n***********************************************************");
            System.out.println("         WELCOME TO LIBRARY");
            System.out.println("***********************************************************\n");

            System.out.println("1. Add book (with duplicate ID check)");
            System.out.println("2. View all books");
            System.out.println("3. Search by Book ID");
            System.out.println("4. Search by Book Name");
            System.out.println("5. Search by Author");
            System.out.println("6. Search by Publisher");
            System.out.println("7. Search by ISBN");
            System.out.println("8. Remove book");
            System.out.println("9. Issue book");
            System.out.println("10. Return book");
            System.out.println("11. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    LibraryManager.addBook(sc);
                    break;
                case 2:
                    LibraryManager.viewAll();
                    break;
                case 3:
                    LibraryManager.searchById(sc);
                    break;
                case 4:
                    LibraryManager.searchByName(sc);
                    break;
                case 5:
                    LibraryManager.searchByAuthor(sc);
                    break;
                case 6:
                    LibraryManager.searchByPublisher(sc);
                    break;
                case 7:
                    LibraryManager.searchByIsbn(sc);
                    break;
                case 8:
                    LibraryManager.removeBook(sc);
                    break;
                case 9:
                    LibraryManager.issueBook(sc);
                    break;
                case 10:
                    LibraryManager.returnBook(sc);
                    break;
                case 11:
                    System.out.println("\n....................................................................");
                    System.out.println("                             Thank You");
                    System.out.println("                          Do visit again");
                    System.out.println("....................................................................");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
