import java.util.HashSet;

/**
 * Longest Substring Without Repeating Characters
 *
 * Algorithm approach:
 * - Sliding window using two pointers (slow, fast) and a HashSet to track characters in the current window.
 * - Expand the fast pointer; when a duplicate character is encountered, move the slow pointer forward
 *   and remove characters from the set until the duplicate is removed.
 *
 * Time complexity: O(n) where n is the length of the string.
 * Space complexity: O(min(n, m)) where m is the size of the character set (extra space for the set).
 *
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">LeetCode - Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int maxLength = Integer.MIN_VALUE;
        while (fast < s.length()) {
            if (!set.contains(s.charAt(fast))) {
                set.add(s.charAt(fast));
                maxLength = Math.max(maxLength, fast - slow + 1);
            }else {
                while (s.charAt(slow) != s.charAt(fast)){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            fast++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
    }
}
