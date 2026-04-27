class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // Signs can only appear at the start OR immediately after an 'e/E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                // Exponent can only appear once and must follow a digit
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false; // Reset to ensure an integer follows the 'e'
            } else if (c == '.') {
                // Dot can only appear once and cannot appear after an exponent
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else {
                // Invalid character
                return false;
            }
        }

        return seenDigit;
    }
}
