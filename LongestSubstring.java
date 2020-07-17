// Time Complexity : O(n) --> where n is the length of input string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (3): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // edge case
        if (s == null || s.length() == 0) return 0;
        
        int max = 0;
        int slow = 0; int fast = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (fast < s.length()) {
            char c = s.charAt(fast);
            if (map.containsKey(c)) {
                slow = Math.max(slow, map.get(c));
            }
            map.put(c, fast + 1);
            max = Math.max(max, fast - slow + 1);
            fast++;
        }
        return max;
    }
}