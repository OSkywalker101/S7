import java.util.Random;

public class Program5_ParallelMergeSort {
    static final int SIZE = 100;
    static final int NUM_THREADS = 4;
    static int[] array = new int[SIZE];
    static int[] temp = new int[SIZE];

    static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }

        for (i = left; i <= right; i++) {
            array[i] = temp[i];
        }
    }

    static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    static class SortChunk implements Runnable {
        int threadId;

        SortChunk(int threadId) {
            this.threadId = threadId;
        }

        public void run() {
            int chunk = SIZE / NUM_THREADS;
            int left = threadId * chunk;
            int right = left + chunk - 1;

            System.out.println("Thread " + threadId + " sorting elements " + left + " to " + right);
            mergeSort(left, right);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            array[i] = rand.nextInt(1000);
        }

        System.out.println("Original Array:");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");

        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(new SortChunk(i));
            threads[i].start();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].join();
        }

        merge(0, 24, 49);
        merge(50, 74, 99);
        merge(0, 49, 99);

        System.out.println("\nSorted Array:");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}