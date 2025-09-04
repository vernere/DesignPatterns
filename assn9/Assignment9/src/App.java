import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int arr1[] = new int[30];
        int arr2[] = new int[100000];

        for (int i = 0; i < 30 - 1; i++) {
            arr1[i] = (int) (Math.random() * 9) + 1;
        }

        for (int i = 0; i < 100000 - 1; i++) {
            arr2[i] = (int) (Math.random() * 9) + 1;
        }

        System.out.println("Choose sorting method 1. BubbleSort 2. SelectionSort 3. InsertionSort : ");
        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        Sorter sorter = new Sorter();

        Strategy s = new BubbleSort();
        Strategy s1 = new SelectionSort();
        Strategy s2 = new InsertionSort();

        if (choice == 1) {
            sorter.setStrategy(s);
            sorter.sort(arr1);
            sorter.sort(arr2);
        }
        if (choice == 2) {
            sorter.setStrategy(s1);
            sorter.sort(arr1);
            sorter.sort(arr2);

        } else {
            sorter.setStrategy(s2);
            sorter.sort(arr1);
            sorter.sort(arr2);

        }

        scanner.close();

    }
}
