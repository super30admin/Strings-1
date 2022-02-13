//  Time Complexity: O(n)
//  Space Complexity: O(n)

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int slow = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                slow = Math.max(slow, map.get(c) + 1);
            }

            map.put(c, i);
            max = Math.max(max, i - slow + 1);
        }

        return max;
    }
}
