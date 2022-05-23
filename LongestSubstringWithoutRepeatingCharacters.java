// Time Complexity :  O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        int left = 0, right = 0, result = 0;
                
        while(right < s.length()) {
            
            char current = s.charAt(right);
            
            if(map.containsKey(current)) {
                
                left = Math.max(left, map.get(current) + 1);
            }
            result = Math.max(result, right - left  + 1);

            map.put(current, right);
            
            right++;
        }
        
        return result;
    }
}