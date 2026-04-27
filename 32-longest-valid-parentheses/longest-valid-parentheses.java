class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLength = 0;

        // Forward pass: left to right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else right++;

            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            } else if (right > left) {
                left = right = 0; // Reset on invalid state
            }
        }

        left = right = 0;

        // Backward pass: right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') left++;
            else right++;

            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            } else if (left > right) {
                left = right = 0; // Reset on invalid state
            }
        }

        return maxLength;
    }
}
