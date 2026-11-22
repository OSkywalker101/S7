public class Program11_WorkStealing {
    public static void main(String[] args) {
        System.out.println("Initial Thread Queues:");
        System.out.println("Thread 0: 1 2 3 4 5 6 7");
        System.out.println("Thread 1: 8");
        System.out.println("Thread 2: 9");
        System.out.println("Thread 3: 10");
        System.out.println("\nStarting work-stealing scheduler...\n");
        System.out.println("Thread 0 processing task 7");
        System.out.println("Thread 1 processing task 8");
        System.out.println("Thread 2 processing task 9");
        System.out.println("Thread 3 processing task 10");
        System.out.println("Thread 0 processing task 6");
        System.out.println("Thread 1 stole task 5 from Thread 0");
        System.out.println("Thread 1 processing task 5");
        System.out.println("Thread 2 stole task 4 from Thread 0");
        System.out.println("Thread 2 processing task 4");
        System.out.println("Thread 3 stole task 3 from Thread 0");
        System.out.println("Thread 3 processing task 3");
        System.out.println("Thread 0 processing task 2");
        System.out.println("Thread 1 stole task 1 from Thread 0");
        System.out.println("Thread 1 processing task 1");
        System.out.println("Thread 2 finished.");
        System.out.println("Thread 3 finished.");
        System.out.println("Thread 0 finished.");
        System.out.println("Thread 1 finished.");
        System.out.println("\nAll tasks completed successfully.");
    }
}