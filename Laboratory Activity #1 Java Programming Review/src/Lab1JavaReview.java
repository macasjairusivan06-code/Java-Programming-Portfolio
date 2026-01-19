import java.util.Scanner;

public class Lab1JavaReview {
    // Max number of books
    static final int MAX_BOOKS = 5;
    static String[] titles = new String[MAX_BOOKS];
    static String[] statuses = new String[MAX_BOOKS];
    static int bookCount = 0; // how many books have been added

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            // Display Main Menu
            System.out.println("\n===== Campus Library System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book Status");
            System.out.println("3. Show All Books");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBook(sc);
                    break;
                case 2:
                    updateBookStatus(sc);
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Thank you for using the Campus Library System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    // 1. Add Book
    public static void addBook(Scanner sc) {
        if (bookCount >= MAX_BOOKS) {
            System.out.println("Book limit reached! Cannot add more books.");
            return;
        }
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        titles[bookCount] = title;
        statuses[bookCount] = "Available"; // default
        bookCount++;
        System.out.println("Book added successfully!");
    }

    // 2. Update Book Status
    public static void updateBookStatus(Scanner sc) {
        if (bookCount == 0) {
            System.out.println("No books to update.");
            return;
        }
        showBooks();
        System.out.print("Enter book number to update: ");
        int bookNum = sc.nextInt();
        sc.nextLine(); // consume newline

        if (bookNum < 1 || bookNum > bookCount) {
            System.out.println("Invalid book number!");
            return;
        }

        // Toggle status
        if (statuses[bookNum - 1].equals("Available")) {
            statuses[bookNum - 1] = "Borrowed";
        } else {
            statuses[bookNum - 1] = "Available";
        }
        System.out.println("Book status updated successfully!");
    }

    // 3. Show All Books
    public static void showBooks() {
        if (bookCount == 0) {
            System.out.println("No books in the system.");
            return;
        }
        System.out.println("\n--- Book List ---");
        for (int i = 0; i < bookCount; i++) {
            System.out.println((i + 1) + ". " + titles[i] + " [" + statuses[i] + "]");
        }
    }

    // 4. Generate Report
    public static void generateReport() {
        System.out.println("\n--- Library Report ---");
        System.out.println("Total books registered: " + bookCount);

        int available = 0, borrowed = 0;
        for (int i = 0; i < bookCount; i++) {
            if (statuses[i].equals("Available")) {
                available++;
            } else if (statuses[i].equals("Borrowed")) {
                borrowed++;
            }
        }

        System.out.println("Total available books: " + available);
        System.out.println("Total borrowed books: " + borrowed);
    }
}
