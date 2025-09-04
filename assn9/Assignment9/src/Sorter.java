public class Sorter {
    public Strategy sortingStrategy;

    public void setStrategy(Strategy s) {
        this.sortingStrategy = s;
    }

    public void sort(int arr[]) {
        int n = arr.length;
        double startTime = System.currentTimeMillis();
        sortingStrategy.sort(arr, n);

        for (int i = 0; i < 30; ++i) {
            System.out.print(arr[i] + " ");
        }

        double endTime = System.currentTimeMillis();

        double timeTaken = endTime - startTime;

        System.out.println("Time taken : " + timeTaken / 1000 + "S");

        System.out.println();

    }
}
