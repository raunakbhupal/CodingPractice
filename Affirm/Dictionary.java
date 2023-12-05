import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class WeightedRandomDictionary<T> {
    private HashMap<T, Integer> valueCountMap;
    private ArrayList<T> keyList;
    private Random random;

    public WeightedRandomDictionary() {
        valueCountMap = new HashMap<>();
        keyList = new ArrayList<>();
        random = new Random();
    }

    public void put(T value) {
        valueCountMap.put(value, valueCountMap.getOrDefault(value, 0) + 1);
        keyList.add(value);
    }

    public T getRandomValue() {
        if (keyList.isEmpty()) {
            return null; // Dictionary is empty
        }

        int randomIndex = random.nextInt(keyList.size());
        return keyList.get(randomIndex);
    }

    public T get() {
        T randomValue = getRandomValue();
        if (randomValue != null) {
            valueCountMap.put(randomValue, valueCountMap.get(randomValue) - 1);
            if (valueCountMap.get(randomValue) == 0) {
                valueCountMap.remove(randomValue);
                keyList.remove(randomValue);
            }
        }
        return randomValue;
    }

    public static void main(String[] args) {
        WeightedRandomDictionary<String> dictionary = new WeightedRandomDictionary<>();

        dictionary.put("A");
        dictionary.put("B");
        dictionary.put("A");
        dictionary.put("C");

        System.out.println(dictionary.get()); // Output: A, B, or C with equal probability
        System.out.println(dictionary.get()); // Output: A, B, or C with equal probability
    }
}
