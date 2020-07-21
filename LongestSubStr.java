// Time Complexity : O(n). n is the length of the string.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s==null || s.length()==0) return 0;
        
        int low=0,max=0,slow=0,fast=0;
        HashMap<Character,Integer> map = new HashMap();
        
        while(fast<s.length()){
            char ch = s.charAt(fast);
            
            if(map.containsKey(ch)){
                slow = Math.max(slow,map.get(ch));    
            }
            map.put(ch,fast+1);
            max = Math.max(max,fast-slow+1);
            fast++;
        }
        return max;
    }
}
