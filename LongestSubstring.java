import java.util.*;

public class LongestSubstring {

    public int longestSubstring(String s) {
        HashMap<Character, Integer> h = new HashMap<>();
        int length = 0;
        int slow = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!h.containsKey(c)) {
                h.put(c, i);
            } else {
                slow = Math.max(slow, h.get(c) + 1);
                h.put(c, i);
            }
            length = Math.max(length, h.get(c) - slow + 1);
        }
        return length;
    }
}
// Sliding Window
// O(n)
// https://leetcode.com/problems/longest-substring-without-repeating-characters/