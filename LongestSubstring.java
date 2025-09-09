// Time Complexity : O(n log k), n -> total no. of nodes, k -> list size
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charset = new HashSet<>();
        int maxLen = 0;
        int len = 0;
        int slow = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!charset.contains(c)) {
                charset.add(c);
                len++;
            } else {
                while(s.charAt(slow) != c) {
                    charset.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
                len = i - slow + 1;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
