// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * We move till we find the same character in the map, if so , we take the index of slow pointer
 * calculate the max length and return the max variable as result.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0, max = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                slow = Math.max(slow, map.get(c));
            }
            max = Math.max(max, i - slow + 1);
            map.put(c, i + 1);
        }
        return max;
    }
}