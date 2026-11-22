public class Program7_ConditionVariables {
    static final int MAX_BREAD = 10;
    static int breadCount = 0;
    static final Object lock = new Object();

    static class Baker implements Runnable {
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (breadCount >= MAX_BREAD) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    breadCount++;
                    System.out.println("Produced bread. Total: " + breadCount);
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

    static class Customer implements Runnable {
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (breadCount <= 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    breadCount--;
                    System.out.println("Consumed bread. Remaining: " + breadCount);
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

    public static void main(String[] args) throws InterruptedException {
        Thread bakerThread = new Thread(new Baker());
        Thread customerThread = new Thread(new Customer());

        bakerThread.start();
        customerThread.start();

        bakerThread.join();
        customerThread.join();
    }
}