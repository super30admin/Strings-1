// Time Complexity : O(N) as we are just iterating through the string once. 
// Space Complexity : O(N) as we are storing each string character and its index in the map.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nope

import java.util.*;

public class LongestNonRepeatingSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int currIndex = 0;
        Map<Character, Integer> charToIndexMap = new HashMap<>();
        int output = 0;
        int temp = 0;

        for(int i = 0; i < s.length(); i++) {
            Character x = s.charAt(i);
            
            if(charToIndexMap.containsKey(x)) {
                if(temp > output) {
                    output = temp;
                }
                
                int lastOccurred = charToIndexMap.get(x);
                currIndex = Math.max(currIndex, lastOccurred);
                temp = i - currIndex;
            } else {
                temp++;
            }
            
            charToIndexMap.put(x, i);
        }
        
        if(temp > output) {
            return temp;
        }
        
        return output;
    }
}
