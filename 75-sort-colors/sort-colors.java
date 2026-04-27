class Solution {
    public void sortColors(int[] nums) {
        int low = 0;          // Boundary for 0s
        int mid = 0;          // Current element being inspected
        int high = nums.length - 1; // Boundary for 2s

        while (mid <= high) {
            if (nums[mid] == 0) {
                // If it's a 0, swap it to the front and move both pointers
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // If it's a 1, it's already in the "middle" zone, just move on
                mid++;
            } else { // nums[mid] == 2
                // If it's a 2, swap it to the back. 
                // Don't increment mid yet, as we need to inspect the swapped value.
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
