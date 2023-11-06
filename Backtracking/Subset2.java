class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> possibleSubsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(possibleSubsets, subset, nums, 0);
        return possibleSubsets;
    }

    public void backtrack(List<List<Integer>> possibleSubsets, List<Integer> subset, int[] nums, int start) {
        // if (possibleSubsets.contains(subset)) {
        //     return;
        // }
        possibleSubsets.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            // skipping over duplicates
            if (i > start && nums[i] == nums[i - 1]) 
                continue;
            subset.add(nums[i]);
            backtrack(possibleSubsets, subset, nums, i+1);
            subset.remove(subset.size() - 1);
        }
    }
}

// either skip over the duplicates as done above, or uncomment the commented code and can use that approach too.
