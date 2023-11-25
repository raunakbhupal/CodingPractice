class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, ans = 0;
        for (int i : nums) {
            if (i == 1) {
                count += 1;
                ans = Math.max(ans, count);
            } else {
                count = 0;
            }
        }
        return ans;
    }
}
