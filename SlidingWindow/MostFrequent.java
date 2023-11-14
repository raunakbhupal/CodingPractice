class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, res = 0, sum = 0;
        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while((j - i + 1) * nums[j] - sum > k) {
                sum -= nums[i];
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
