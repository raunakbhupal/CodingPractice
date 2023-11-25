// 1493. Longest Subarray of 1's After Deleting One Element

class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0, zero = 0, ans = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                zero++;
            }
            while (zero > 1) {
                if (nums[i] == 0){
                    zero--;
                }
                i++;
            }
            // since deleting there won't be a +1 to window size
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}
