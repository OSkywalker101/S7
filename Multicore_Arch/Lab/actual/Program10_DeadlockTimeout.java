import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Program10_DeadlockTimeout {
    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    static class Worker implements Runnable {
        int threadId;

        Worker(int threadId) {
            this.threadId = threadId;
        }

        public void run() {
            Lock first = threadId == 0 ? lock1 : lock2;
            Lock second = threadId == 0 ? lock2 : lock1;

            first.lock();
            try {
                Thread.sleep(1000);
                System.out.println("Thread " + threadId + ": Waiting for other lock...");

                if (second.tryLock(2, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Thread " + threadId + ": Acquired other lock.");
                    } finally {
                        second.unlock();
                    }
                } else {
                    System.out.println("Thread " + threadId + ": Timeout! Releasing first lock.");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                first.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new Worker(0));
        Thread t1 = new Thread(new Worker(1));

        t0.start();
        t1.start();

        t0.join();
        t1.join();
    }
}