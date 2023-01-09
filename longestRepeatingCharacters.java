// Time Complexity : O(n) // n is the length of the String s
// Space Complexity : O(1) //at max 26 characters would be stored at once
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // base
        if (s.length() == 0 || s.length() == 1)
            return s.length();
        Map<Character, Integer> uniqueMap = new HashMap();
        int i = 0, length = 0;
        ;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (uniqueMap.containsKey(ch)) {
                // calculate length
                length = Math.max(length, j - i);
                // update i
                i = Math.max(i, uniqueMap.get(ch) + 1);
            }
            // update index
            uniqueMap.put(ch, j);
        }
        // calcualte length at the end
        length = Math.max(length, s.length() - i);
        return length;
    }
}