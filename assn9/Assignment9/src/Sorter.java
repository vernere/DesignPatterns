/**
 * A class that performs sorting operations using different strategies.
 * This implements the Strategy Design Pattern.
 */
public class Sorter {
    // The sorting strategy to be used
    public Strategy sortingStrategy;

    /**
     * Sets the sorting strategy to be used.
     * @param s The strategy to use for sorting
     */
    public void setStrategy(Strategy s) {
        this.sortingStrategy = s;
    }

    /**
     * Sorts the given array using the current sorting strategy.
     * Also prints the first 30 elements of the sorted array and the time taken.
     * @param arr The array to be sorted
     */
    public void sort(int arr[]) {
        int n = arr.length;
        
        // Record start time for performance measurement
        double startTime = System.currentTimeMillis();
        
        // Execute the sorting algorithm based on the current strategy
        sortingStrategy.sort(arr, n);

        // Print the first 30 elements of the sorted array
        for (int i = 0; i < 30; ++i) {
            System.out.print(arr[i] + " ");
        }

        // Record end time
        double endTime = System.currentTimeMillis();

        // Calculate and display execution time
        double timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken / 1000 + "S");
        
        System.out.println();
    }
}
