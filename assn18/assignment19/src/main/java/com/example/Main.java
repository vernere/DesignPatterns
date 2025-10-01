package com.example;

import java.util.List;
import java.util.Scanner;

/**
 * Main class demonstrating the use of Book and Recommendation classes
 * with a prototype pattern implementation through RecommendationManager.
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create several book objects representing different literary works
        Book book1 = new Book("Moby Dick", "Herman Melville");
        Book book2 = new Book("Pride and Prejudice", "Jane Austen");
        Book book3 = new Book("1984", "George Orwell");
        Book book4 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book5 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book6 = new Book("Don Quixote", "Miguel de Cervantes");
        Book book7 = new Book("War and Peace", "Leo Tolstoy");

        // Create a RecommendationManager to store and manage recommendations
        // This manager implements the prototype pattern for cloning recommendations
        RecommendationManager manager = new RecommendationManager();

        // Create a recommendation for classic literature enthusiasts
        Recommendation classicsRecommendation = new Recommendation();
        classicsRecommendation.setTargetAudience("Classic Literature Fans");
        classicsRecommendation.addBook(book1); // Moby Dick
        classicsRecommendation.addBook(book2); // Pride and Prejudice

        // Create a recommendation for modern fiction readers
        Recommendation modernRecommendation = new Recommendation();
        modernRecommendation.setTargetAudience("Modern Fiction Readers");
        modernRecommendation.addBook(book3); // 1984
        modernRecommendation.addBook(book4); // To Kill a Mockingbird
        modernRecommendation.addBook(book5); // The Great Gatsby

        // Save recommendations to the manager using unique keys
        manager.saveRecommendation("classics", classicsRecommendation);
        manager.saveRecommendation("modern", modernRecommendation);

        // Clone the classics recommendation and modify it for a different audience
        Recommendation classicsClone = manager.cloneRecommendation("classics");
        classicsClone.setTargetAudience("19th Century Literature Enthusiasts");
        classicsClone.addBook(book6); // Add Don Quixote to the cloned recommendation

        // Save the cloned recommendation with a new key
        manager.saveRecommendation("19thCentury", classicsClone);

        // Create a recommendation using the bulk add method
        Recommendation epicNovelRecommendation = new Recommendation();
        epicNovelRecommendation.setTargetAudience("Epic Novel Readers");
        epicNovelRecommendation.addBooks(java.util.Arrays.asList(book1, book7)); // Add multiple books at once

        // Save the new epic novels recommendation
        manager.saveRecommendation("epicNovels", epicNovelRecommendation);

        // Main application loop
        while (true) {
            int choice = 0;

            // Display menu options
            System.out.println("\n===== Book Recommendation System =====");
            System.out.println("1. Show all recommendations");
            System.out.println("2. Clone an existing recommendation");
            System.out.println("3. Add a book to recommendation");
            System.out.println("4. Remove a book from recommendation");
            System.out.println("5. Create new recommendation");
            System.out.println("6. View specific recommendation");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            // Process user's choice
            switch (choice) {
                case 1:
                    // Display all available recommendations
                    manager.listRecommendations();
                    break;
                case 2:
                    // Clone an existing recommendation and save it with a new name
                    sc.nextLine(); // Clear input buffer
                    System.out.println("Recommendation name to clone: ");
                    String rcCloneName = sc.nextLine();
                    Recommendation rcClone = manager.cloneRecommendation(rcCloneName);
                    System.out.println("Target audience: ");
                    String targetAudience = sc.nextLine();
                    System.out.println("Name: ");
                    String rcName = sc.nextLine();
                    rcClone.setTargetAudience(targetAudience);
                    manager.saveRecommendation(rcName, rcClone);
                    break;
                case 3:
                    // Add a new book to an existing recommendation
                    sc.nextLine(); // Consume the leftover newline character
                    System.out.println("Book: ");
                    String bookName = sc.nextLine();
                    System.out.println("Author: ");
                    String authorName = sc.nextLine();
                    Book book = new Book(bookName, authorName);
                    System.out.println("Recommendation: ");
                    String recommendationName = sc.nextLine();
                    Recommendation rc = manager.getRecommendation(recommendationName);
                    rc.addBook(book);
                    // Display updated book list
                    List<Book> list = rc.getBooks();
                    for (Book books : list) {
                        System.out.println(books.toString());
                    }
                    break;
                case 4:
                    // Remove a book from an existing recommendation
                    sc.nextLine(); // Clear input buffer
                    System.out.println("Recommendation: ");
                    String recommendationNames = sc.nextLine();
                    Recommendation rc1 = manager.getRecommendation(recommendationNames);
                    // Display current books in the recommendation
                    List<Book> list1 = rc1.getBooks();
                    for (Book books : list1) {
                        System.out.println(books.toString());
                    }
                    System.out.println("Book: ");
                    String bookNames = sc.nextLine();
                    rc1.removeBookByTitle(bookNames);
                    System.out.println("Book removed successfully!");
                    break;
                case 5:
                    // Create a new empty recommendation
                    sc.nextLine();
                    System.out.print("Recommendation target audience: ");
                    String tA = sc.nextLine();
                    System.out.print("Recommendation name ");
                    String targetName = sc.nextLine();
                    Recommendation recommendationNew = new Recommendation();
                    recommendationNew.setTargetAudience(tA);
                    manager.saveRecommendation(targetName, recommendationNew);
                    manager.listRecommendations();
                    break;
                case 6:
                    // View details of a specific recommendation
                    sc.nextLine();
                    manager.listRecommendations();
                    System.out.println("Recommendation: ");
                    String recommendationSearch = sc.nextLine();
                    Recommendation rs = manager.getRecommendation(recommendationSearch);
                    // Display all books in the selected recommendation
                    List<Book> listSearch = rs.getBooks();
                    for (Book books : listSearch) {
                        System.out.println(books.toString());
                    }
                    break;
                case 7:
                    // Exit the application
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}