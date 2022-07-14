// Time Complexity : O(n) 
// Space Complexity : O(26) -> O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No  

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                s low = Math.max(slow, map.get(c));
            }
            max = Math.max(max, i - slow + 1);
            map.put(c,i+1);
        }
        return max;
    }
}