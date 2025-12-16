import java.util.HashSet;

/**
 * Longest Substring Without Repeating Characters (sliding window - remove until duplicate)
 *
 * Algorithm approach:
 * - Sliding window with a HashSet storing current window characters.
 * - Iterate with a single pointer `i`; when a duplicate is found, advance `slow` and remove
 *   characters from the set until the duplicate is removed.
 *
 * Time complexity: O(n) where n is the length of the string (each character is added/removed at most once).
 * Space complexity: O(min(n, m)) where m is the character set size.
 *
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">LeetCode - Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters2 {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int slow = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                while (s.charAt(slow) != ch) {
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            } else {
                set.add(ch);
            }
            maxLength = Math.max(maxLength, i - slow + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters2().lengthOfLongestSubstring("abcabcbb"));
    }
}
