/**
 * Sliding window approach using a HashSet to maintain a window with all unique characters.
 * Expand right pointer and shrink left pointer whenever a duplicate is found to restore validity.
 * The window always represents a valid substring with no repeating characters.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(min(n, charset size))
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int left = 0; 
        int right = 0; 
        Set<Character> charSet = new HashSet(); 
        int max = 0;

        while (right < s.length()) {
            // Maintain invariant: window [left, right) has all unique characters
            while (charSet.contains(s.charAt(right))) {
                // Remove from left until duplicate is eliminated
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(s.charAt(right)); // safe to add since duplicate removed
            // Window is always valid here → update max length
            max = Math.max(max, right - left + 1);
            right++; // expand window
        }
        return max;
    }
}

public class LongestSubstringWithoutRepeatingCharacters {
        public int lengthOfLongestSubstring(String s) {
        int left = 0; 
        int right = 0; 
        Set<Character> charSet = new HashSet(); 
        int max = 0;

        while(right < s.length()) {
            while(charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            max = Math.max(max, right-left+1);
            right++;
        }
        return max;
    }
    
}
