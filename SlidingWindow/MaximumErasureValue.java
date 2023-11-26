class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i = 0, sum = 0, max = 0;
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < nums.length; j++) {
            while (set.contains(nums[j])) {
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            set.add(nums[j]);
            sum += nums[j];
            max = Math.max(max, sum);
        }
        return max;
    }
}
