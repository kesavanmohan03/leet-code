import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sorting helps to stop early once the number exceeds the remaining target
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // Optimization: if the number is greater than the remaining sum, no point in continuing
            if (nums[i] > remain) break; 

            tempList.add(nums[i]);
            // Important: we pass 'i' as the start index, not 'i + 1', because we can reuse the same element
            backtrack(result, tempList, nums, remain - nums[i], i);
            // Remove the last element (backtrack)
            tempList.remove(tempList.size() - 1);
        }
    }
}
