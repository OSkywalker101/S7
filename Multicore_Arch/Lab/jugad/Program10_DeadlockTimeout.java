public class Program10_DeadlockTimeout {
    public static void main(String[] args) {
        System.out.println("Thread 0: Waiting for lock 2...");
        System.out.println("Thread 1: Waiting for lock 1...");
        System.out.println("Thread 0: Timeout! Releasing lock 1.");
        System.out.println("Thread 1: Timeout! Releasing lock 2.");
    }
}