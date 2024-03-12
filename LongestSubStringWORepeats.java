// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashSet;
import java.util.Set;

//TC: O(n)
//SC: O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int max = 0;
        int n = s.length();
        int ptr1 = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                // slide the window
                while (s.charAt(ptr1) != c) {
                    set.remove(s.charAt(ptr1));
                    ptr1++;
                }
                ptr1++;
            }

            set.add(c);
            max = Math.max(max, i - ptr1 + 1);
        }
        return max;
    }
}