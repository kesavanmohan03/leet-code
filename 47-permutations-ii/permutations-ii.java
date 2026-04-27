import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 1. Sort to handle duplicates
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 2. Skip if the element is already used in this specific path
            if (used[i]) continue;

            // 3. Skip duplicates: if current is same as previous and previous wasn't used
            // This ensures we only use the first available duplicate to start a sequence
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            tempList.add(nums[i]);
            
            backtrack(result, tempList, nums, used);
            
            // 4. Backtrack
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
