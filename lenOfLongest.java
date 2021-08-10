// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLen = 0, slow = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            //update slow pointer
            if(charMap.containsKey(ch)){
                slow = Math.max(slow, charMap.get(ch));
            }
            
            //update index
            charMap.put(ch, i + 1);
            maxLen = Math.max(maxLen, i - slow + 1);
        }
        
        return maxLen;
    }
}