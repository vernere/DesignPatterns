package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Recommendation class implements the Prototype interface.
 * It represents a book recommendation list for a specific target audience.
 */
public class Recommendation implements Prototype {
    public String targetAudience;   // The audience this recommendation is intended for
    public List<Book> books;        // Collection of recommended books

    /**
     * Default constructor initializes an empty book list
     */
    public Recommendation() {
        this.books = new ArrayList<Book>();
    }

    /**
     * Add multiple books to the recommendation list
     * Each book is cloned before being added
     * 
     * @param booksList List of books to be added
     */
    public void addBooks(List<Book> booksList) {
        for (Book book : booksList) {
            Book newBook = book.clone();
            books.add(newBook);
            System.out.println(book.toString() + " added to list");
        }
    }

    /**
     * Add a single book to the recommendation list
     * The book is cloned before being added
     * 
     * @param book Book to be added
     */
    public void addBook(Book book) {
        Book newBook = book.clone();
        books.add(newBook);
        System.out.println(book.toString() + " added to list");
    }

    /**
     * Remove a book from the recommendation list
     * 
     * @param book Book to be removed
     */
    public void removeBook(Book book) {
        books.remove(book);
        System.out.println(book.toString() + " removed from list");
    }

    /**
     * Remove a book from the recommendation list by its title
     * 
     * @param name Title of the book to be removed
     */
    public void removeBookByTitle(String name) {
        books.removeIf(book -> book.getName().equals(name));
        System.out.println(name.toString() + " removed from list");
    }

    /**
     * Get the number of books in the recommendation list
     * 
     * @return Number of books in the list
     */
    public int getBookCount() {
        int count = books.size();
        return count;
    }

    /**
     * Check if a specific book is in the recommendation list
     * 
     * @param book Book to check for
     * @return true if the book is in the list, false otherwise
     */
    public boolean containsBook(Book book) {
        if (books.contains(book)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Create a deep clone of this recommendation
     * Implements the clone method from Prototype interface
     * 
     * @return A new Recommendation object with cloned properties
     */
    @Override
    public Recommendation clone() {
        Recommendation newRecommendation = new Recommendation();
        newRecommendation.targetAudience = this.targetAudience;
        for (Book book : this.books) {
            newRecommendation.books.add(book.clone());
        }
        return newRecommendation;
    }

    /**
     * Get the target audience for this recommendation
     * 
     * @return Target audience string
     */
    public String getTargetAudience() {
        return targetAudience;
    }

    /**
     * Set the target audience for this recommendation
     * 
     * @param targetAudience New target audience value
     */
    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    /**
     * Get the list of recommended books
     * 
     * @return List of Book objects
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Replace the current book list with a new one
     * All books are cloned before being added
     * 
     * @param books New list of books
     */
    public void setBooks(List<Book> books) {
        this.books.clear();
        addBooks(books);
    }
}
