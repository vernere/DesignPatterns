package com.example;

/**
 * The Prototype interface defines a method for cloning objects.
 * It's part of the Prototype design pattern which allows objects
 * to create copies of themselves.
 */
public interface Prototype {
    /**
     * Creates and returns a clone of the implementing object.
     * 
     * @return A new instance that is a copy of the original object
     */
    public Prototype clone();
}
