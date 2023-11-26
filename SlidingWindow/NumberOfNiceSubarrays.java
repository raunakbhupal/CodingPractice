//1248. Count Number of Nice Subarrays

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {
        int i = 0, ans = 0, count = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 1) {
                count ++;
            }
            while (count > k) {
                if (nums[i] % 2 == 1) {
                    count--;
                }
                i++;
            }
            ans += j-i;
        }
        return ans;
    }
}
