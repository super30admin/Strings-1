// Time Complexity : O(n)= O(n) where 'n' is the length of the string.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Any problem you faced while coding this : No


class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int slow = 0;
        int max=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
              slow= Math.max(slow,map.get(c)+1);
            }
            map.put(c,i);
            max = Math.max(max,i-slow+1);
        }
        return max;
    }
}
