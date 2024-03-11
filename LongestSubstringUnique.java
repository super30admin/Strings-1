// Time: O(n)
// Space: O(1) 

// Approach: Indexmap to maintain the last position of a character.
// If you encounter the same character again, check if it lies in the window or not
// and update res accordingly

import java.util.HashMap;
import java.util.Map;

class LongestSubstringUnique {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indexMap = new HashMap<>();
        int start = 0;
        int end = 0;
        int res = 0;

        while (end < s.length()) {
            char curr = s.charAt(end);
            // new curr not in window
            if (!indexMap.containsKey(curr) || indexMap.get(curr) < start) {
                indexMap.put(curr, end);
                res = Math.max(res, end - start + 1);
            } else {
                start = indexMap.get(curr) + 1;
                indexMap.put(curr, end);
            }
            end++;
        }
        return res;
    }
}