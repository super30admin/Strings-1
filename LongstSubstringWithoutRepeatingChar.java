// Time Complexity : O(2n) --> O(n) n - length of the string s
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int slow=0; int fast=0; int result =0;
        while(fast<s.length())
        {
            char c=s.charAt(fast);
            if(map.containsKey(c))
            {
                slow=Math.max(slow,map.get(c)+1);
            }
            result=Math.max(result,fast-slow+1);
            map.put(c,fast);
            fast++;
        }
        
        return result;
    }
}