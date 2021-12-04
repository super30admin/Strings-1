// 3. Longest Substring Without Repeating Characters
// Solved on leetcode
// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int fast = 0;
        int max=0;
        HashMap < Character, Integer > map = new HashMap<>();
        
        while(fast < s.length()){
            char ch = s.charAt(fast);
            if(map.containsKey(ch)){
                slow=Math.max(slow,map.get(ch));
            }
                 map.put(ch,fast+1);
                 max= Math.max(max,fast-slow+1);
                 fast++;
            
            
        }
        return max;
    }
}