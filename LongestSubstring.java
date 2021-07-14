// Time Complexity : O((n)),
// Space Complexity : O(1), at max hashmap will only have 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package strings1;

import java.util.*;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0, max = 0;
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
