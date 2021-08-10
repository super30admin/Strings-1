//Time complexity: O(N), where N is the length of string s.
//Space complexity: O(N)

import java.util.*;

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0; 
        HashMap<Character, Integer> map = new HashMap<>(); 
        int left = 0;
        for(int right=0; right<s.length(); right++) {
            char c = s.charAt(right); 
            if(map.containsKey(c)) {
                left = Math.max(left, map.get(c)+1); 
            }
            map.put(c,right);
            maxLength = Math.max(maxLength, right - left + 1); 
        }
        return maxLength; 
    }
}