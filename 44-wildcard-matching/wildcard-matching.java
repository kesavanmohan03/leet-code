class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx = 0, pIdx = 0, match = 0, starIdx = -1;            
        
        while (sIdx < s.length()) {
            // 1. Characters match or pattern has '?'
            if (pIdx < p.length() && (p.charAt(pIdx) == '?' || s.charAt(sIdx) == p.charAt(pIdx))) {
                sIdx++;
                pIdx++;
            }
            // 2. Pattern has '*', record the position and try matching 0 characters first
            else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                match = sIdx;
                pIdx++;
            }
            // 3. Current characters don't match, but a '*' was previously encountered
            // Backtrack: move the star match forward by one character in s
            else if (starIdx != -1) {
                pIdx = starIdx + 1;
                match++;
                sIdx = match;
            }
            // 4. No match and no previous '*'
            else {
                return false;
            }
        }
        
        // Check for remaining characters in pattern (only '*' can remain)
        while (pIdx < p.length() && p.charAt(pIdx) == '*') {
            pIdx++;
        }
        
        return pIdx == p.length();
    }
}
