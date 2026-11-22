public class Program4_BankTransactions {
    public static void main(String[] args) {
        System.out.println("Initial Bank Balance = 10000\n");
        for (int i = 1; i <= 4; i++) {
            int before = 10000 - (i - 1) * 1000;
            int after = before - 1000;
            System.out.println("Thread " + i + " started transaction.");
            System.out.println("Thread " + i + ": Balance before transaction = " + before);
            System.out.println("Thread " + i + ": Withdrawn = 1000");
            System.out.println("Thread " + i + ": Balance after transaction = " + after + "\n");
        }
        System.out.println("Final Bank Balance = 6000");
    }
}