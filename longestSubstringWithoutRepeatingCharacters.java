//time complexity: O(N) where n is the lenght of string
//space complexity: O(N) where n is the lenght of string

import java.util.*;
class LongestSubstringSolution {
    
    // Use set to add character with two pointers to find the window with substring
    public int lengthOfLongestSubstring(String s) {
    int i = 0, j = 0, max = 0;
    Set<Character> set = new HashSet<>();
    
    while (j < s.length()) {
        if (!set.contains(s.charAt(j))) {
            set.add(s.charAt(j++));
            max = Math.max(max, set.size());
        } else {
            set.remove(s.charAt(i++));
        }
    }
    
    return max;
    }
}