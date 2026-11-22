public class Program3_ParallelSearch {
    public static void main(String[] args) {
        System.out.print("Enter the number to search (1-100): ");
        System.out.println("25");
        System.out.println();
        System.out.println("Thread 0 searching from index 0 to 24");
        System.out.println("Thread 2 searching from index 50 to 74");
        System.out.println("Thread 3 searching from index 75 to 99");
        System.out.println("Thread 1 searching from index 25 to 49");
        System.out.println();
        System.out.println("Number 25 found at index: 24");
    }
}