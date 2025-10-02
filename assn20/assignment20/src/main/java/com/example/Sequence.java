package com.example;

import java.util.Iterator;

/**
 * The Sequence interface represents a sequence of integers.
 * It follows the Iterator design pattern by providing a way to access elements sequentially.
 */
public interface Sequence {
    /**
     * Creates and returns an Iterator for traversing through the sequence elements.
     * 
     * @return an Iterator object that allows sequential access to the integers in this sequence
     */
    public Iterator<Integer> createIterator();
}
