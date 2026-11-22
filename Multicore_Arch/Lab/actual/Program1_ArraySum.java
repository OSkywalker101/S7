public class Program1_ArraySum {
    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
    static int sum1 = 0;
    static int sum2 = 0;

    static class SumFirstHalf implements Runnable {
        public void run() {
            for (int i = 0; i < 4; i++) {
                sum1 += arr[i];
            }
        }
    }

    static class SumSecondHalf implements Runnable {
        public void run() {
            for (int i = 4; i < 8; i++) {
                sum2 += arr[i];
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new SumFirstHalf());
        Thread t2 = new Thread(new SumSecondHalf());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        int totalSum = sum1 + sum2;
        System.out.println("Total Sum: " + totalSum);
    }
}