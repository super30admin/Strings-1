// Time Complexity : O(n) n is the length of the string s.
// Space Complexity : O(n) n is the length of the string s, for storing the latest occurance.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> charToNextIndex = new HashMap<>(); 
        for (int j = 0, i = 0; j < n; j++) {
            if (charToNextIndex.containsKey(s.charAt(j))) {
                i = Math.max(charToNextIndex.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            charToNextIndex.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}