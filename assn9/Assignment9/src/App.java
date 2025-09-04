import java.util.Scanner;

/**
 * Main application class demonstrating the Strategy pattern for sorting algorithms
 */
public class App {
    public static void main(String[] args) throws Exception {
        // Initialize a small array with 30 elements
        int arr1[] = new int[30];
        // Initialize a large array with 100000 elements
        int arr2[] = new int[100000];

        // Fill the small array with random integers between 1 and 9
        for (int i = 0; i < 30 - 1; i++) {
            arr1[i] = (int) (Math.random() * 9) + 1;
        }

        // Fill the large array with random integers between 1 and 9
        for (int i = 0; i < 100000 - 1; i++) {
            arr2[i] = (int) (Math.random() * 9) + 1;
        }

        // Prompt user to select a sorting algorithm
        System.out.println("Choose sorting method 1. BubbleSort 2. SelectionSort 3. InsertionSort : ");
        Scanner scanner = new Scanner(System.in);

        // Get user's choice
        int choice = scanner.nextInt();

        // Create sorter object that will use the strategy pattern
        Sorter sorter = new Sorter();

        // Initialize different sorting strategies
        Strategy s = new BubbleSort();
        Strategy s1 = new SelectionSort();
        Strategy s2 = new InsertionSort();

        // Apply the selected sorting strategy to both arrays
        if (choice == 1) {
            // Use Bubble Sort
            sorter.setStrategy(s);
            sorter.sort(arr1);
            sorter.sort(arr2);
        }
        if (choice == 2) {
            // Use Selection Sort
            sorter.setStrategy(s1);
            sorter.sort(arr1);
            sorter.sort(arr2);
        } 
        if (choice == 3) {
            // Use Insertion Sort
            sorter.setStrategy(s2);
            sorter.sort(arr1);
            sorter.sort(arr2);
        }

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}
