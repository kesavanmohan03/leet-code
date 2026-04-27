import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
        // Base case: if the combination is the required size
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Optimization: i <= n - (k - current.size()) + 1
        // This ensures there are enough numbers left to actually finish the combination
        for (int i = start; i <= n; i++) {
            current.add(i);
            // Move to i + 1 to ensure we only pick numbers to the right (combinations)
            backtrack(result, current, i + 1, n, k);
            // Backtrack: remove the last added number
            current.remove(current.size() - 1);
        }
    }
}
