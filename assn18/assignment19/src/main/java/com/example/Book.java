package com.example;

import java.util.Objects;

/**
 * The Book class represents a book entity with name and author attributes.
 * It implements the Prototype interface to support cloning functionality.
 */
public class Book implements Prototype {
    private String name;   // Stores the name/title of the book
    private String author; // Stores the author of the book

    /**
     * Default constructor - creates an empty Book instance.
     */
    public Book() {
    }

    /**
     * Parameterized constructor - creates a Book with specified name and author.
     * 
     * @param name   The title of the book
     * @param author The author of the book
     */
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    /**
     * Gets the book's name/title.
     * 
     * @return The name of the book
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the book's name/title.
     * 
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the book's author.
     * 
     * @return The author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the book's author.
     * 
     * @param author The author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Creates a clone of this Book object.
     * Implementation of the Prototype pattern.
     * 
     * @return A new Book instance with the same attributes as this one
     */
    @Override
    public Book clone() {
        return new Book(this.name, this.author);
    }

    /**
     * Returns a string representation of the Book.
     * 
     * @return A string containing the book's name and author
     */
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    /**
     * Compares this Book with another object for equality.
     * Two Books are equal if they have the same name and author.
     * 
     * @param o The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(author, book.author);
    }

    /**
     * Generates a hash code for this Book.
     * 
     * @return A hash code based on the book's name and author
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, author);
    }
}
