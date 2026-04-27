class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;

        while (num <= n * n) {
            // 1. Fill top row (Left to Right)
            for (int j = left; j <= right; j++) {
                matrix[top][j] = num++;
            }
            top++;

            // 2. Fill right column (Top to Bottom)
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // 3. Fill bottom row (Right to Left)
            for (int j = right; j >= left; j--) {
                matrix[bottom][j] = num++;
            }
            bottom--;

            // 4. Fill left column (Bottom to Top)
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }

        return matrix;
    }
}

