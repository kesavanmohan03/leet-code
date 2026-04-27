import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // 1. Create a list of numbers to use: [1, 2, 3...n]
        // 2. Precompute factorials: [1, 1, 2, 6, 24...]
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
            numbers.add(i);
        }

        // Adjust k to be 0-indexed for easier math
        k--;

        // 3. Find the digit for each position
        for (int i = 1; i <= n; i++) {
            // How many permutations exist for the remaining (n-i) positions
            int index = k / factorial[n - i];
            
            sb.append(numbers.get(index));
            numbers.remove(index); // Remove used digit
            
            k %= factorial[n - i]; // Update k for the next position
        }

        return sb.toString();
    }
}
