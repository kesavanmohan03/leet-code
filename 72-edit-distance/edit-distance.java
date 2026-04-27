class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // dp[i][j] will be the distance between word1.substring(0, i) 
        // and word2.substring(0, j)
        int[][] dp = new int[m + 1][n + 1];
        
        // Base cases: converting a string to an empty string requires i/j deletions
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match, no new operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Take the minimum of Insert, Delete, or Replace and add 1
                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];
                    
                    dp[i][j] = 1 + Math.min(replace, Math.min(insert, delete));
                }
            }
        }
        
        return dp[m][n];
    }
}
