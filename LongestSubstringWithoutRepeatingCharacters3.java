import java.util.HashMap;

/**
 * Longest Substring Without Repeating Characters (sliding window with last-seen index)
 *
 * Algorithm approach:
 * - Use a HashMap to store the last index where each character appeared.
 * - Iterate with index `i` and keep a `slow` pointer for the start of the window.
 * - When a repeated character is found, move `slow` to max(slow, lastIndex + 1).
 *
 * Time complexity: O(n) where n is the length of the string.
 * Space complexity: O(min(n, m)) where m is the character set size.
 *
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">LeetCode - Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            /* if (map.containsKey(ch) && map.get(ch) >= slow) {
                slow = map.get(ch) + 1;
            }*/
            if (map.containsKey(ch)) {
                slow = Math.max(slow, map.get(ch) + 1);
            }

            map.put(ch, i);

            maxLength = Math.max(maxLength, i - slow + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("abcabcbb"));
    }
}
