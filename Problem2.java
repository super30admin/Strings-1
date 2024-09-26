// Time Complexity : O(n) where n = length of S
// Space Complexity : O(n) Hash Map
// Did this code successfully run on Leetcode : Yes
// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s== null || s.length() == 0) return 0;
        
        int maxWindow = 0; int slow =0; int fast =0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(fast < s.length())
        {
            char c = s.charAt(fast);
            if(map.containsKey(c))
            {
                slow = Math.max(slow, map.get(c));
            }
            map.put(c, fast+1);       
            maxWindow = Math.max(maxWindow, (fast-slow +1));
            fast++;
        }
        return maxWindow;  
    }
}