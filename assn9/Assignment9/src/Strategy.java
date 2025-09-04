/**
 * The Strategy interface defines a family of sorting algorithms.
 * Classes that implement this interface provide different
 * implementations of the sort method to arrange an array
 * of integers in a specific order.
 * 
 * This interface is part of the Strategy design pattern
 * which enables selecting an algorithm at runtime.
 */
public interface Strategy {


    public void sort(int arr[], int n);

}
