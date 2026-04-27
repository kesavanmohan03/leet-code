import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words.length == 0) return result;

        int n = s.length();
        int wordCount = words.length;
        int wordLen = words[0].length();
        int totalLen = wordCount * wordLen;

        // Map to store frequency of each word in the input array
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // We run the sliding window starting from each possible offset within one word length
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> currentWindowFreq = new HashMap<>();

            while (right + wordLen <= n) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordFreq.containsKey(word)) {
                    currentWindowFreq.put(word, currentWindowFreq.getOrDefault(word, 0) + 1);
                    count++;

                    // If we have more occurrences of 'word' than needed, slide the left window
                    while (currentWindowFreq.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentWindowFreq.put(leftWord, currentWindowFreq.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // If all words are matched
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Not a valid word, reset the window
                    currentWindowFreq.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}
