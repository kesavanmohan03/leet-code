import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            
            // 1. Determine how many words fit in the current line
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int diff = last - index - 1; // Number of gaps between words

            // 2. Handle Last Line or Single Word Line (Left Justified)
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) sb.append(" ");
            } 
            // 3. Handle Fully Justified Line
            else {
                int spaces = (maxWidth - count) / diff;
                int extra = (maxWidth - count) % diff;
                
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        // Base space is 1 (accounted for in 'count') + distributed spaces
                        int spacesToApply = 1 + spaces + ((i - index < extra) ? 1 : 0);
                        for (int s = 0; s < spacesToApply; s++) sb.append(" ");
                    }
                }
            }
            
            result.add(sb.toString());
            index = last;
        }

        return result;
    }
}
