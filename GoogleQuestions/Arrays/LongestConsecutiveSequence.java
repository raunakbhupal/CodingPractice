public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) set.add(num);        // O(1) lookups, dedups too

    int longest = 0;

    for (int num : set) {
        // only start counting if num is the beginning of a run
        if (!set.contains(num - 1)) {
            int current = num;
            int length = 1;

            while (set.contains(current + 1)) {   // walk up the run
                current++;
                length++;
            }

            longest = Math.max(longest, length);
        }
    }

    return longest;
}
