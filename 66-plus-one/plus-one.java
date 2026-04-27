class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Iterate from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                // If we incremented a digit < 9, we are done
                return digits;
            }
            
            // If it's 9, it becomes 0 and the loop carries over to the next digit
            digits[i] = 0;
        }
        
        // If the loop finishes, it means all digits were 9 (e.g., 999 -> 000)
        // We need a new array with an extra leading 1 (e.g., 1000)
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}
