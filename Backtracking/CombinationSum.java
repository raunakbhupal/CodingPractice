class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> uniqueCombinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(uniqueCombinations, combination, candidates, 0, target);
        return uniqueCombinations;
    }

    public void backtrack(List<List<Integer>> uniqueCombinations, List<Integer> combination, int[] candidates, int start, int target) {
        if (target == 0) {
            uniqueCombinations.add(new ArrayList<>(combination));
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtrack(uniqueCombinations, combination, candidates, i, target - candidates[i]);
            combination.remove(combination.size() - 1);
        }
    }
}
