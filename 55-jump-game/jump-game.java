class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If the current index is greater than the farthest reachable point,
            // it means we've hit a gap we can't cross.
            if (i > reachable) return false;
            
            // Update the farthest index we can reach from the current spot
            reachable = Math.max(reachable, i + nums[i]);
            
            // Optimization: if we can already reach the end, return true
            if (reachable >= nums.length - 1) return true;
        }
        
        return true;
    }
}
