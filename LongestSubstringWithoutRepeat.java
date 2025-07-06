import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Leetcode 3. Longest Substring Without Repeating Characters
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
//------------------------------------ Solution 1 -----------------------------------
public class LongestSubstringWithoutRepeat {
    /**
     * Sliding window solution where we expand our window on right side while keeping left fixed until we find a repeating
     * character. (Use Set to find repeats). Once a repeat is found we move our left side window until we skip the first
     * occurrence of that character and along the way remove characters from the set to prep our set for next sliding window
     * iteration.
     *
     * TC: O(n) 2 pass through both left and right pointers
     * SC: O(1) max 26 chars in the set so constant
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int result = 0;
        Set<Character> strSet = new HashSet<>();

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if(strSet.contains(c)) {
                while (s.charAt(left) != c) {
                    strSet.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                strSet.add(c);
            }
            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}

//------------------------------------ Solution 2 -----------------------------------
class LongestSubstringWithoutRepeat2 {
    /**
     * We can produce a one pass solution using a Hashmap where character and its index are stored.
     * upon a repeat jump left pointer to right of previous index of that character. As we are jumping we won't be
     * removing the characters from previous window but instead check for repeat in the current window only by checking
     * if the repeat is happening only beyond current left pointer.
     *
     * TC: O(n) one pass
     * SC: O(1)
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if(map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}