public class InsertionSort implements Strategy {

    // https://www.geeksforgeeks.org/dsa/insertion-sort-algorithm/
    // Code used from geeksforgeeks and modified slighlty to fit interface.

    @Override
    public void sort(int[] arr, int n) {
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /*
             * Move elements of arr[0..i-1], that are
             * greater than key, to one position ahead
             * of their current position
             */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

}
