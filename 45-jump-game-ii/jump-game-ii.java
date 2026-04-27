class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // We don't need to jump if we are already at the last element
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest point reachable from the current index
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of the current jump's range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                
                // Optimization: if we can already reach the end, break
                if (currentEnd >= nums.length - 1) break;
            }
        }

        return jumps;
    }
}
