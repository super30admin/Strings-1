// Time Complexity : O(n); where n = length of the string 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int max = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // check if the character is already present 
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            
            // store character and it's index + 1 value so that we can skip it
            map.put(c, i+1);
            max = Math.max(max, i - slow + 1);
            // System.out.println(c + ", i : " + i + ", Slow: " + slow + ", Max : " + max);
        }
        
        return max;
    }
}