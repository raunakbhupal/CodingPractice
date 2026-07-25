class Solution {
    public int[] numbersAboveThreshold(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int key : map.keySet()) {          // loop over the KEYS (the numbers)
            if (map.get(key) >= k) {            // check that number's count
                res.add(key);
            }
        }

        // convert List<Integer> → int[]
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}

// heap
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: count frequencies (same as before)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: min-heap ordered by frequency, keep only k elements
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)      // compare by frequency, smallest on top
        );

        for (int num : map.keySet()) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();                        // evict the LEAST frequent
            }
        }

        // Step 3: heap now holds the k most frequent — drain into result
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}
