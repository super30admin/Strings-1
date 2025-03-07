import java.util.HashMap;
import java.util.Map;

// TC: O(n) all the characters are visited.
// SC: O(n) as Map has been used

// Runs successfully on leetcode
// While traversing the string, characters are checked in map and if it exists, start is updated.
// max is updated for every iteration.
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int max = 0;
        int start = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            if (map.containsKey(curr)) {
                start = Math.max(start, map.get(curr));
            }
            max = Math.max(max, i - start + 1);
            map.put(curr, i + 1);
        }
        return max;
    }
}
