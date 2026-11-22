public class Program6_ProducerConsumer {
    public static void main(String[] args) {
        String[] log = {
            "Producer: Produced task 1",
            "Consumer: Consumed task 1",
            "Producer: Produced task 2",
            "Consumer: Consumed task 2",
            "Producer: Produced task 3",
            "Producer: Produced task 4",
            "Consumer: Consumed task 3",
            "Producer: Produced task 5",
            "Producer: Produced task 6",
            "Consumer: Consumed task 4",
            "Producer: Produced task 7",
            "Producer: Produced task 8",
            "Consumer: Consumed task 5",
            "Producer: Produced task 9",
            "Producer: Produced task 10",
            "Consumer: Consumed task 6",
            "Consumer: Consumed task 7",
            "Consumer: Consumed task 8",
            "Consumer: Consumed task 9",
            "Consumer: Consumed task 10",
            "",
            "All tasks completed."
        };
        for (String line : log) System.out.println(line);
    }
}