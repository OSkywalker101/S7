public class Program11_WorkStealing {
    static final int NUM_TASKS = 10;
    static final int NUM_THREADS = 4;

    static int[][] queues = new int[NUM_THREADS][NUM_TASKS];
    static int[] queueSize = new int[NUM_THREADS];
    static final Object[] locks = new Object[NUM_THREADS];

    static class Worker implements Runnable {
        int threadId;

        Worker(int threadId) {
            this.threadId = threadId;
        }

        public void run() {
            while (true) {
                int task = -1;

                synchronized (locks[threadId]) {
                    if (queueSize[threadId] > 0) {
                        queueSize[threadId]--;
                        task = queues[threadId][queueSize[threadId]];
                    }
                }

                if (task == -1) {
                    for (int i = 0; i < NUM_THREADS; i++) {
                        if (i == threadId) {
                            continue;
                        }
                        synchronized (locks[i]) {
                            if (queueSize[i] > 0) {
                                queueSize[i]--;
                                task = queues[i][queueSize[i]];
                            }
                        }
                        if (task != -1) {
                            System.out.println("Thread " + threadId + " stole task " + task + " from Thread " + i);
                            break;
                        }
                    }
                }

                if (task == -1) {
                    break;
                }

                System.out.println("Thread " + threadId + " processing task " + task);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            System.out.println("Thread " + threadId + " finished.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < NUM_THREADS; i++) {
            queueSize[i] = 0;
            locks[i] = new Object();
        }

        for (int i = 1; i <= NUM_TASKS; i++) {
            int owner;
            if (i <= 7) {
                owner = 0;
            } else {
                owner = i - 7;
            }
            queues[owner][queueSize[owner]] = i;
            queueSize[owner]++;
        }

        System.out.println("Initial Thread Queues:");
        for (int i = 0; i < NUM_THREADS; i++) {
            System.out.print("Thread " + i + ": ");
            for (int j = 0; j < queueSize[i]; j++) {
                System.out.print(queues[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nStarting work-stealing scheduler...\n");

        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(new Worker(i));
            threads[i].start();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].join();
        }

        System.out.println("\nAll tasks completed successfully.");
    }
}