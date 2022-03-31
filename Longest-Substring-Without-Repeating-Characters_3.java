
// Time Complexity : O(n) where n is the lengthof string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// iterate over string char by char and put it in map with index, once  you encounter same char with index > start, then reset the start and update max size

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        int i = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            if (map.containsKey(s.charAt(i)) && map.get(c) >= start) {

                    max = Math.max(max, i-start);
                    start = map.get(c) + 1;
                    map.put(c, i);
            }
            map.put(c, i);
            i++;
        }

        max = Math.max(max, i-start);

        return max;
    }
}
