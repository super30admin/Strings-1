// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int end=0; end< s.length(); end++){
            char c = s.charAt(end);
            
            if(map.containsKey(c)){
                start = Math.max(start, map.get(c)+1);
            }      
            map.put(c, end);
            
            max = Math.max(max, end-start+1);    
        }
        return max;
    }
}
