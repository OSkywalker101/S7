public class Program9_ImageProcessing {
    static final int NUM_TASKS = 4;

    static void blur() {
        System.out.println("Thread " + Thread.currentThread().getId() + ": Blurring the image...");
    }

    static void sharpen() {
        System.out.println("Thread " + Thread.currentThread().getId() + ": Sharpening the image...");
    }

    static void contrast() {
        System.out.println("Thread " + Thread.currentThread().getId() + ": Adjusting image contrast...");
    }

    static void resizeImage() {
        System.out.println("Thread " + Thread.currentThread().getId() + ": Resizing the image...");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("OpenMP Task Parallelism - Image Processing");
        System.out.println("Number of tasks: " + NUM_TASKS + "\n");

        long startTime = System.nanoTime();

        Thread t1 = new Thread(Program9_ImageProcessing::blur);
        Thread t2 = new Thread(Program9_ImageProcessing::sharpen);
        Thread t3 = new Thread(Program9_ImageProcessing::contrast);
        Thread t4 = new Thread(Program9_ImageProcessing::resizeImage);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        long endTime = System.nanoTime();

        System.out.println("\nAll image processing tasks completed.");
        System.out.printf("Execution time: %f seconds%n", (endTime - startTime) / 1e9);
    }
}