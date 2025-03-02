// TC: O(n) where n is the length of the string
// SC: O(1) since we are using a fixed size set of 26 characters

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {

        int l = s.length();
        if (l <= 1) return l;

        Set<Character> chars = new HashSet<>();
        int left = 0, right = 0;
        int max = 0;
        // initially left and right pointers are at 0
        while (right < l) {
            // the 'right' character
            char c = s.charAt(right);
            // if the set contains this character we have duplicates
            while (chars.contains(c)) {
                // move 'left' until the duplicates are removed
                chars.remove(s.charAt(left++));
            }
            // now add the 'right' character into the set
            chars.add(c);
            // update the max length if necessary
            if (max < (right - left + 1)) max = right - left + 1;
            // move 'right'
            right++;
        }
        return max;
    }
}
