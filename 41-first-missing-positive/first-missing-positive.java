class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 1. Cyclic Sort: Place each number x at index x-1 if possible
        for (int i = 0; i < n; i++) {
            // Check if nums[i] is in the valid range [1, n] 
            // and not already at its correct position
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 2. Find the first index where the value doesn't match the index
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 3. If all numbers 1 to n are present, the answer is n + 1
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
