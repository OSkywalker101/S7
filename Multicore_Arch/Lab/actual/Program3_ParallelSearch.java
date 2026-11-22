import java.util.Scanner;

public class Program3_ParallelSearch {
    static final int SIZE = 100;
    static final int NUM_THREADS = 4;
    static int[] data = new int[SIZE];
    static int searchValue;
    static int foundIndex = -1;
    static final Object lock = new Object();

    static class SearchTask implements Runnable {
        int threadId;

        SearchTask(int threadId) {
            this.threadId = threadId;
        }

        public void run() {
            int start = threadId * (SIZE / NUM_THREADS);
            int end = start + (SIZE / NUM_THREADS);

            System.out.println("Thread " + threadId + " searching from index " + start + " to " + (end - 1));

            for (int i = start; i < end; i++) {
                if (data[i] == searchValue) {
                    synchronized (lock) {
                        if (foundIndex == -1) {
                            foundIndex = i;
                        }
                    }
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < SIZE; i++) {
            data[i] = i + 1;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number to search (1-100): ");
        searchValue = scanner.nextInt();
        scanner.close();

        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(new SearchTask(i));
            threads[i].start();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].join();
        }

        if (foundIndex != -1) {
            System.out.println("\nNumber " + searchValue + " found at index: " + foundIndex);
        } else {
            System.out.println("\nNumber " + searchValue + " not found in the array.");
        }
    }
}