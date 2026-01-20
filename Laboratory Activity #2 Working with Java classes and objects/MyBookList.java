package org.example;

public class MyBookList {
    public static void main(String[] args) {

        // 1. Create 5 book objects using the Book class
        Book bk1 = new Book("The Silent Patient", "Alex Michaelides", 2019);
        Book bk2 = new Book("The Alchemist", "Paulo Coelho", 1988);
        Book bk3 = new Book("Deep Work", "Cal Newport", 2016);
        Book bk4 = new Book("Learning Java", "Evelyn Hart", 2021);
        Book bk5 = new Book("Pride and Prejudice", "Jane Austen", 1813);

        // 2. Display all books (initially all on page 0)
        System.out.println("\n--- Book Collection ---");
        bk1.showInfo();
        bk2.showInfo();
        bk3.showInfo();
        bk4.showInfo();
        bk5.showInfo();

        // 3. Change reading progress for some books
        bk1.updatePage(42);
        bk3.updatePage(87);
        System.out.println("\n--- Updated Reading Progress ---");
        bk1.showInfo();
        bk3.showInfo();

        // 4. Update favorite book’s progress
        bk5.updatePage(150);
        System.out.println("\n--- Favorite Book Progress ---");
        bk5.showInfo();

        // 5. Modify author of 'Learning Java'
        bk4.updateAuthor("Daniel Moore");
        System.out.println("\n--- Revised Author Info ---");
        bk4.showInfo();

        // 6. Store all books in an array and list those released after 2010
        Book[] bookArray = {bk1, bk2, bk3, bk4, bk5};
        System.out.println("\n--- Books Released After 2010 ---");
        for (Book item : bookArray) {
            if (item.getYearReleased() > 2010) {
                System.out.println("- " + item.getTitle());
            }
        }
    }
}
