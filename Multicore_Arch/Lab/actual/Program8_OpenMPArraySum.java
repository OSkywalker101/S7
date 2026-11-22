import java.util.Random;

public class Program8_OpenMPArraySum {
    static final int SIZE = 1000000;

    public static void main(String[] args) {
        int[] array = new int[SIZE];
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            array[i] = rand.nextInt(100);
        }

        long start, end;

        long sequentialSum = 0;
        start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            sequentialSum += array[i];
        }
        end = System.nanoTime();
        System.out.println("\n===== SEQUENTIAL =====");
        System.out.println("Sum : " + sequentialSum);
        System.out.printf("Time : %f seconds%n", (end - start) / 1e9);

        start = System.nanoTime();
        long parallelSum = java.util.Arrays.stream(array).parallel().sum();
        end = System.nanoTime();
        System.out.println("\n===== PARALLEL =====");
        System.out.println("Sum : " + parallelSum);
        System.out.printf("Time : %f seconds%n", (end - start) / 1e9);

        System.out.println("\n===== RESULT CHECK =====");
        if (sequentialSum == parallelSum) {
            System.out.println("Both sums are equal.");
        } else {
            System.out.println("Results are different!");
        }
    }
}