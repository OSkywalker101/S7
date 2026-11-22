public class Program2_MatrixAddition {
    static final int SIZE = 3;
    static int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    static int[][] B = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
    static int[][] C = new int[SIZE][SIZE];

    static class AddRow implements Runnable {
        int row;

        AddRow(int row) {
            this.row = row;
        }

        public void run() {
            for (int j = 0; j < SIZE; j++) {
                C[row][j] = A[row][j] + B[row][j];
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[SIZE];

        for (int i = 0; i < SIZE; i++) {
            threads[i] = new Thread(new AddRow(i));
            threads[i].start();
        }

        for (int i = 0; i < SIZE; i++) {
            threads[i].join();
        }

        System.out.println("Resultant Matrix:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}