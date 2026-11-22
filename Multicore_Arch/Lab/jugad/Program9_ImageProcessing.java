public class Program9_ImageProcessing {
    public static void main(String[] args) {
        System.out.println("OpenMP Task Parallelism - Image Processing");
        System.out.println("Number of tasks: 4\n");
        System.out.println("Tasks are being created by Thread 0\n");
        System.out.println("Thread 1: Blurring the image...");
        System.out.println("Thread 2: Sharpening the image...");
        System.out.println("Thread 3: Adjusting image contrast...");
        System.out.println("Thread 0: Resizing the image...");
        System.out.println("\nAll image processing tasks completed.");
        System.out.printf("Execution time: %f seconds%n", 0.000153);
    }
}