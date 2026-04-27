import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        // Base case: if the current list size matches the input size, we found a permutation
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip if the element is already in the current permutation
            if (tempList.contains(nums[i])) continue;

            // Choose the element
            tempList.add(nums[i]);
            
            // Explore further
            backtrack(result, tempList, nums);
            
            // Backtrack: remove the element to try other possibilities
            tempList.remove(tempList.size() - 1);
        }
    }
}
