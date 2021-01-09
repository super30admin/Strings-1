// Time Complexity : O(n) where n is length of s
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No

// Your code here along with comments explaining your approach:MAintain 2 pointers slow and fast. iterate through each character in the 
// string. Add each character to hashmap with the index+1. Also check if it is already present in the hashmap, if present update slow
// accordingly. Also maintain the count and check with result to update if greater than previous.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result=Integer.MIN_VALUE;
        if(s==null || s.length()==0)
            return 0;
        int slow=0;int fast=0;int count=0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(fast<s.length()){
            char c = s.charAt(fast);
            if(map.containsKey(c))
                slow=Math.max(slow,map.get(c));
                map.put(c,fast+1);
   
            
                count= fast-slow+1;
                result=Math.max(result,count);
            fast++;
        }
        return result;
    }
}