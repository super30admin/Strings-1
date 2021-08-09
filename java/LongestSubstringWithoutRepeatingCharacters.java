// Time Complexity : O(2N) = O(n)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while (i < s.length()) {

            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j));
                j++;
            }

            set.add(s.charAt(i));
            i++;

            max = Math.max(max, set.size());
        }

        return max;
    }
}