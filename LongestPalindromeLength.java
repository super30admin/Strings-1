// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are traversing through the entire string
//Space Complexity: O(n) since we are using any extra space

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int res = 0;
        if(s == null || s.length() == 0) return 0;
        
        HashMap<Character,Integer> map = new HashMap<>(); // store character and corresponding index
        
        int left = 0;
        int right = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                left = Math.max(map.get(c), left);
            }
            res = Math.max(res, right - left + 1);
            map.put(c, right + 1);
            right++;
        }
               
        return res;
    }
}