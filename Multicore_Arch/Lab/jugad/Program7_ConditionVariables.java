public class Program7_ConditionVariables {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Produced bread. Total: " + i);
            System.out.println("Consumed bread. Remaining: " + (i - 1));
        }
    }
}