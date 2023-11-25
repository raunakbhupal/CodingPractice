class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0, prod = 1, ans = 0;
        for (int j = 0; j < nums.length; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            // since each max window will give j-i+1 valid subarrays
            // and we need to find the total subarrays
            ans += j - i + 1;
        }
        return ans;
    }
}
