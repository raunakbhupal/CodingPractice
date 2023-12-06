import java.util.PriorityQueue;
import java.util.TreeMap;

public class AmountProcessor {

    private TreeMap<Integer, Integer> hourToAmountMap;
    private PriorityQueue<Integer> hourQueue;

    public AmountProcessor() {
        hourToAmountMap = new TreeMap<>();
        hourQueue = new PriorityQueue<>();
    }

    public void process_amount(int amount, int hour) {
        // Update the amount for the given hour
        hourToAmountMap.put(hour, hourToAmountMap.getOrDefault(hour, 0) + amount);

        // Add the hour to the priority queue
        hourQueue.add(hour);

        // Remove the oldest hour if it's more than one hour ago
        int oldestHour = hour - 1;
        while (!hourQueue.isEmpty() && hourQueue.peek() <= oldestHour) {
            hourToAmountMap.remove(hourQueue.poll());
        }
    }

    public int process_total_amount(int currentHour) {
        // Calculate the start hour for the total amount calculation (1 hour ago)
        int startHour = currentHour - 1;

        // Calculate the total amount processed within the continuous hours
        int totalAmount = 0;
        for (int hour : hourToAmountMap.tailMap(startHour).keySet()) {
            totalAmount += hourToAmountMap.get(hour);
        }

        return totalAmount;
    }

    public static void main(String[] args) {
        AmountProcessor processor = new AmountProcessor();

        // Example: Process amounts for a few hours
        processor.process_amount(50, 3);
        processor.process_amount(30, 4);
        processor.process_amount(20, 5);
        processor.process_amount(40, 6);

        // Example: Process total amount at 4:20 PM
        int currentHour = 16; // 4:00 PM
        int totalAmount = processor.process_total_amount(currentHour);

        System.out.println("Total amount processed in the last hour: " + totalAmount);
    }
}
