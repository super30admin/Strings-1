//https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
// Time Complexity : O(n) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s==null) return 0;
        HashMap<Character,Integer> map=new HashMap<>();
        //using sliding window concept
        int slow=0;
        int max=Integer.MIN_VALUE;
       for(int fast=0;fast<s.length();fast++)
       {
           char c=s.charAt(fast);
          if(map.containsKey(c))
          {                              
                  slow=Math.max(slow,map.get(c)); //when a char is found and is less than slow dont consider
           }
          max=Math.max(max,fast-slow+1);
          map.put(c,fast+1); 
       }
        return max;
    }
}