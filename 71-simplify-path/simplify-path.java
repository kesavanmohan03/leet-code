import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        // Split by one or more slashes
        String[] components = path.split("/");

        for (String directory : components) {
            // Rule: ".." means go up a level (pop from stack if not empty)
            if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } 
            // Skip empty strings (from ///) and current directory "."
            else if (!directory.isEmpty() && !directory.equals(".")) {
                stack.push(directory);
            }
        }

        // Build the canonical path
        StringBuilder result = new StringBuilder();
        // We use descendingIterator or collect to get elements in correct order
        for (Iterator<String> it = stack.descendingIterator(); it.hasNext(); ) {
            result.append("/").append(it.next());
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}
