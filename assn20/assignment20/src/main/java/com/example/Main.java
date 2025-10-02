package com.example;

import java.util.Iterator;

/**
 * Main class that demonstrates the use of a Fibonacci sequence iterator.
 */
public class Main {
    /**
     * Main method that creates a Fibonacci sequence and prints the first 10 numbers.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a new Fibonacci sequence
        FibonacciSequence fs = new FibonacciSequence();
        // Get an iterator for the sequence
        Iterator<Integer> fi = fs.createIterator();

        // Loop to print the first 10 Fibonacci numbers
        for (int i = 0; i < 10; i++) {
            if (fi.hasNext()) {
                // Get the next number in the sequence
                Integer number = fi.next();
                // Print the number followed by a newline
                System.out.print(number + "\n");
            } else {
                // This would execute if the iterator runs out of numbers
                // (which shouldn't happen with Fibonacci sequence)
                System.out.println("10 numbers finished");
            }
        }
    }
}