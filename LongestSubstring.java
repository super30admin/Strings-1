// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        int maxLen = 0;

        while (start < s.length() && end < s.length()) {
            Character ch = s.charAt(end);

            while (set.contains(ch)) {
                set.remove(s.charAt(start++));
            }

            set.add(ch);
            maxLen = Math.max(maxLen, set.size());
            end++;
        }
        return maxLen;
    }
}
