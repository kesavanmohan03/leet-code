class Solution {
    public int uniquePaths(int m, int n) {
        // Use a 1D array to save space. 
        // dp[j] will store the number of ways to reach the current cell in column j.
        int[] dp = new int[n];
        
        // Base case: There's only 1 way to reach any cell in the first row (all Rights)
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Iterate through the rest of the rows
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // New dp[j] = old dp[j] (from cell above) + dp[j-1] (from cell to left)
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
