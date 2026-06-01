import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Start backtracking from index 0 with an empty combination list
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] candidates, int target, 
                           List<Integer> current, List<List<Integer>> result) {
        // Base Case 1: Success
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Make a deep copy
            return;
        }

        // Base Case 2: Failure (Overshot sum or ran out of candidates)
        if (target < 0 || index >= candidates.length) {
            return;
        }

        // Choice 1: Include candidates[index]
        current.add(candidates[index]);
        // Note: index does NOT change because we can reuse the same number
        backtrack(index, candidates, target - candidates[index], current, result);
        
        // Backtrack: Remove the number we just added before making the next choice
        current.remove(current.size() - 1);

        // Choice 2: Skip candidates[index] and move to the next number
        backtrack(index + 1, candidates, target, current, result);
    }
}