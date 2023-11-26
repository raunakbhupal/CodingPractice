//930. Binary Subarrays With Sum

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    public int atMost(int[] nums, int goal) {
        int i=0, sum = 0, ans = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (i <= j && sum > goal) {
                sum -= nums[i];
                i++;
            }
            ans += j-i;
        }
        return ans;
    }
}
