// Time Complexity : O(n+m) where m is 26 so it becomes O(n)
// Space Complexity : O(m) where m is 26 so it becomes O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class Solution {
    public String customSortString(String order, String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            
            char x = s.charAt(i);
            
            map.put(x, map.getOrDefault(x, 0)+1); // following 1-indexing and considering chars not in order as 0
        }
        
        StringBuilder ans = new StringBuilder();
        
        for (int i = 0; i < order.length(); i++) {
            
            char c = order.charAt(i);
            
            int frequency = map.getOrDefault(c, 0);
            
            while (frequency > 0) {
                ans.append(c);
                frequency--;
            }
            
            map.remove(c);
        }
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char remaining = entry.getKey();
            int frequency = entry.getValue();
            
            while (frequency > 0) {
                ans.append(remaining);
                frequency--;
            }
        }
        
        return ans.toString();
    }
}