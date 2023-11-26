// 2009. Minimum Number of Operations to Make Array Continuous
class Solution {
    public int minOperations(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Integer[] sortedNums = set.toArray(new Integer[0]);
        Arrays.sort(sortedNums);
        int r = 0;
        int res = length;
        for (int l = 0; l < sortedNums.length; l++) {
            /*
            the range we will go through is sortedNums[l] , sortedNums[l] + length - 1
            but we are going till one past the end value of our range
            thus we will be removing the "-1" from there
            */
            while (r < sortedNums.length && sortedNums[r] < sortedNums[l] + length) {
                r++;
            }
            /*
            generally window size is r-l+1 but here r is exclusive, we are not including it and thus it will be r-l
            */
            int window = r - l;
            res = Math.min(res, length - window);
        }
        return res;
    }
}
