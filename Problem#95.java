// Longest Substring Without Repeating Characters

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int slow = 0, max = 0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            max = Math.max(max,i - slow + 1);
            map.put(c, i + 1);
        }
        return max;
    }
}