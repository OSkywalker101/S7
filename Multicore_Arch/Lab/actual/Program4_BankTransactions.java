public class Program4_BankTransactions {
    static final int NUM_THREADS = 4;
    static int balance = 10000;
    static final Object lock = new Object();

    static class Transaction implements Runnable {
        int threadId;

        Transaction(int threadId) {
            this.threadId = threadId;
        }

        public void run() {
            int amount = 1000;

            synchronized (lock) {
                System.out.println("Thread " + threadId + " started transaction.");
                System.out.println("Thread " + threadId + ": Balance before transaction = " + balance);

                if (balance >= amount) {
                    balance -= amount;
                    System.out.println("Thread " + threadId + ": Withdrawn = " + amount);
                    System.out.println("Thread " + threadId + ": Balance after transaction = " + balance + "\n");
                } else {
                    System.out.println("Thread " + threadId + ": Insufficient balance\n");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];

        System.out.println("Initial Bank Balance = " + balance + "\n");

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(new Transaction(i + 1));
            threads[i].start();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].join();
        }

        System.out.println("Final Bank Balance = " + balance);
    }
}