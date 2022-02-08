class Solution {
    // Time Complexity : O(n), where n is the length of input string s
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();

        if(len == 1) {
            return 1;
        }
        int max = 0;
        int start = 0;
        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                start = Math.max(start, map.get(ch));
                map.put(ch, i+1);
            } else {
                map.put(ch, i+1);
            }
            max = Math.max(max, i-start+1);
        }
        return max;
    }
}