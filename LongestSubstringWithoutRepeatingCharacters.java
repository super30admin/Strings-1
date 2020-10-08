import java.util.HashMap;

/* 3. Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/
// TC: O(n) => n - length of string, we are traversing once through the string
// SC: O(m) => m - number of unique characters
// Approach: keep a sliding window that contains no duplicates.
Increment left ptr if a duplicate is found. Update maximum length as we slide the window.
*/

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int left = 0, right = 0, max = Integer.MIN_VALUE;
        HashMap<Character, Integer> countMap = new HashMap<>();
        
        while (right < s.length() && left < s.length()) {
            char r = s.charAt(right);
            if (!countMap.containsKey(r) || countMap.get(r) == 0) {
                countMap.put(r, 1);
                // mistake that I made: updated length after incrementing right
                max = Math.max(max, right-left+1);
                right++;
            } else {
                char l = s.charAt(left);
                int leftCount = countMap.get(l);
                countMap.put(l, leftCount-1);
                left++;
            }
        }
        
        return max;
    }

    public static void main(String args[]) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("b b bac"));
    }
}
