package com.example;

import java.util.Iterator;

/**
 * A class representing a Fibonacci sequence that implements the Sequence interface.
 * The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones.
 */
public class FibonacciSequence implements Sequence {
    /** The upper limit for Fibonacci numbers to be generated */
    private int limit = 1000;
    
    /** The initial value to start the Fibonacci sequence */
    private int startingValue = 1;

    /**
     * Creates an iterator that will generate Fibonacci numbers.
     * @return An iterator that produces Fibonacci numbers up to the specified limit
     */
    @Override
    public Iterator<Integer> createIterator() {
        Iterator<Integer> ite = new FibonacciIterator(limit, startingValue, startingValue);
        return ite;
    }
}
