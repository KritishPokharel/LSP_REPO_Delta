package org.howard.edu.lsp.midterm.question2;
//References used:
//https://www.geeksforgeeks.org/
//https://www.programiz.com/

/**
 * Represents a book in a library.
 */
public class Book {
    // Private variables for encapsulation
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;

    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * Checks if this Book is equal to another object.
     * Two books are considered equal if they have the same ISBN and author.
     *
     * @param obj the object to compare against
     * @return true if both books are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return ISBN.equals(other.ISBN) && author.equals(other.author);
    }

    /**
     * Returns a string representation of the book.
     *
     * @return a formatted string with title, author, ISBN, and publication year
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN +
               ", Year Published: " + yearPublished;
    }
}
