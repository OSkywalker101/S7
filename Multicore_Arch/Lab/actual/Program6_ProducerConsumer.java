public class Program6_ProducerConsumer {
    static final int BUFFER_SIZE = 5;
    static final int NUM_TASKS = 10;
    static int[] buffer = new int[BUFFER_SIZE];
    static int in = 0;
    static int out = 0;
    static int count = 0;
    static final Object lock = new Object();

    static class Producer implements Runnable {
        public void run() {
            for (int task = 1; task <= NUM_TASKS; task++) {
                synchronized (lock) {
                    while (count == BUFFER_SIZE) {
                        try {
                            System.out.println("Producer: Buffer full, waiting...");
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    buffer[in] = task;
                    System.out.println("Producer: Produced task " + task);
                    in = (in + 1) % BUFFER_SIZE;
                    count++;

                    lock.notify();
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    static class Consumer implements Runnable {
        public void run() {
            for (int i = 1; i <= NUM_TASKS; i++) {
                synchronized (lock) {
                    while (count == 0) {
                        try {
                            System.out.println("Consumer: Buffer empty, waiting...");
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    int task = buffer[out];
                    System.out.println("Consumer: Consumed task " + task);
                    out = (out + 1) % BUFFER_SIZE;
                    count--;

                    lock.notify();
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("\nAll tasks completed.");
    }
}