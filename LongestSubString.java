import java.util.*;

/**
 * Time Complexity: O(N) N is length of String
 * Space Complexity: O(1)
 * 
 * Approach:
 * 1. Slinding window approach where we store the starting index of every window in the hashmap.
 * 2. When the window contains the repeating character, we will update the index of that character.
 * 3. Maximum size of such window is the final answer.
 */

class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0)
            return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i-start+1);
            
        }
        
        return maxLen;
    }
}