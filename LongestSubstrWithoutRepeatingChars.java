// Time Complexity : O(m)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Creating an Hashset to store the characters and slide the window when duplicate char found

import java.util.HashSet;

public class LongestSubstrWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int i = 0, j = 0;
        int max = 0;
        while (j < s.length()) {
            if (hs.contains(s.charAt(j))) {
                hs.remove(s.charAt(i));
                i++;
            } else {
                hs.add(s.charAt(j));
                j++;
                max = Math.max(max, hs.size());
            }
        }
        return max;
    }
}
