package com.example;

import java.util.Iterator;
/* 
 * State Management Decision:
 * 
 * The state of this Fibonacci sequence is managed within the iterator itself
 * using three instance variables:
 * 1. prevInt - stores the current number in the sequence
 * 2. prevPrevInt - stores the previous number in the sequence
 * 3. counter - tracks both the current position and (after initialization) the current value
 * 
 * Rationale:
 * - This approach keeps the state encapsulated within the iterator, following the
 *   Iterator pattern's principle of maintaining traversal state internally.
 * - Using instance variables makes the implementation thread-safe for a single iterator
 *   instance (though multiple iterators would have independent states).
 */
/**
 * An iterator that generates Fibonacci sequence numbers.
 * Implements the Iterator interface to allow iteration through a limited
 * number of Fibonacci numbers.
 */
public class FibonacciIterator implements Iterator<Integer> {
    // Current number in sequence
    int prevInt;
    // Previous number in sequence
    int prevPrevInt;
    // Current value (sum of prevInt and prevPrevInt)
    int counter;
    // Maximum number of iterations allowed
    int limit;

    /**
     * Constructs a FibonacciIterator with specified parameters.
     * 
     * @param limit       Maximum number of iterations
     * @param prevInt     The current number in the sequence
     * @param prevPrevInt The previous number in the sequence
     */
    public FibonacciIterator(int limit, int prevInt, int prevPrevInt) {
        this.counter = 0;
        this.prevInt = prevInt;
        this.prevPrevInt = prevPrevInt;
        this.limit = limit;
    }

    /**
     * Checks if there are more elements in the iteration.
     * 
     * @return true if the iteration has more elements, false otherwise
     */
    @Override
    public boolean hasNext() {
        if (counter >= limit) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns the next Fibonacci number in the sequence.
     * 
     * @return the next Fibonacci number
     */
    @Override
    public Integer next() {
        if (counter == 0) {
            return ++counter;
        }
        if (counter == 1) {
            return counter++;
        } else {
            counter = prevPrevInt + prevInt;
            prevPrevInt = prevInt;
            prevInt = counter;
            return counter;
        }
    }
}
