class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> possibleSubsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(possibleSubsets, subset, nums, 0);
        return possibleSubsets;
    }

    public void backtrack(List<List<Integer>> possibleSubsets, List<Integer> subset, int[] nums, int start) {
        // adding the set to the final list
        possibleSubsets.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            // case when we are selecting a subset
            subset.add(nums[i]);
            backtrack(possibleSubsets, subset, nums, i+1);
            // case when we are not selecting a subset
            subset.remove(subset.size() - 1);
        }
    }
}
