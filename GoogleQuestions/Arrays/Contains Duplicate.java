class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
        }

        for (int count : hmap.values()) {
            if (count > 1) {
                return true;
            }
        }

        return false;
    }
}
