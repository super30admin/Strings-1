//Problem1 - https://leetcode.com/problems/custom-sort-string/

// Time Complexity : O(n)
// Space Complexity : O(1) //Constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

public class problem1 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int slow = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                slow = Math.max(slow, map.get(s.charAt(i)));
            }
            max = Math.max(max, i - slow + 1);
            map.put(s.charAt(i), i + 1);
        }
        return max;
    }
}
