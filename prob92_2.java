// S30 Big N Problem #92 {Medium}
// 3. Longest Substring Without Repeating Characters
// Time Complexity :O(n) where n is the length of string 
// Space Complexity :O(n) {Hashmap} where n is the length of the string
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s==null) return 0;
        
        HashMap<Character,Integer> map=new HashMap<>();
        int slow=0, fast=0, max=0;
        
        while(fast < s.length()){
            Character c=s.charAt(fast);
            if(map.containsKey(c)){
                slow=Math.max(slow,map.get(c));
            }
            map.put(c,fast+1);
            max=Math.max(max,fast-slow+1);
            fast++;
        }
        return max;       
    }
}