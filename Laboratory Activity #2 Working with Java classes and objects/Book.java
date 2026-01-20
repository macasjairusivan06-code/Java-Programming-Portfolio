package org.example;

public class Book {
    private String title;
    private String author;
    private int yearReleased;
    private int currentPage;

    // Constructor
    public Book(String title, String author, int yearReleased) {
        this.title = title;
        this.author = author;
        this.yearReleased = yearReleased;
        this.currentPage = 0; // default starting page
    }

    // Displays all book info
    public void showInfo() {
        System.out.println("Title: " + title + ", Author: " + author + 
                           ", Year: " + yearReleased + ", Current Page: " + currentPage);
    }

    // Updates the current page
    public void updatePage(int pageNumber) {
        if (pageNumber >= 0) {
            this.currentPage = pageNumber;
        }
    }

    // Updates the author name
    public void updateAuthor(String author) {
        this.author = author;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getYearReleased() {
        return yearReleased;
    }
}
