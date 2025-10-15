// Time Complexity : O(2n) where n is the length of the string
// Space Complexity : O(n) for character set
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using 2 pointers approach to see which characters are unique between the current window. If a repeat character was found, move the left pointer till the repeat character is reached. Calculate maximum length at each new character
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                max = Math.max(max, i - left + 1);
                set.add(ch);
            } else {
                // move the left pointer till the repeat character
                while (s.charAt(left) != ch) {
                    // remove from the set to maintain the unique elements in current window
                    set.remove(s.charAt(left));
                    left++;
                }
                // going one more inde in left to escape the repeat character so that the new window starts from one character after the repeat character
                left++;
            }
        }

        return max;

    }
}