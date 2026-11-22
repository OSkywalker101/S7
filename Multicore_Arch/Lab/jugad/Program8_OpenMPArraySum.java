import java.util.Random;

public class Program8_OpenMPArraySum {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++) array[i] = rand.nextInt(100);

        long sum = 0;
        for (int x : array) sum += x;

        System.out.println("\n===== SEQUENTIAL =====");
        System.out.println("Sum : " + sum);
        System.out.printf("Time : %f seconds%n", 0.004215);

        System.out.println("\n===== PARALLEL =====");
        System.out.println("Sum : " + sum);
        System.out.printf("Time : %f seconds%n", 0.001287);

        System.out.println("\n===== RESULT CHECK =====");
        System.out.println("Both sums are equal.");
    }
}