
// Time Complexity : O(s)
// Space Complexity : O(1) -> 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c)); // to move the sliding window, determies all the non repeating characters wrt the index
            }
            max = Math.max(max, i - start + 1); // setting max value
            map.put(c, i + 1);
        }
        return max;
    }
}