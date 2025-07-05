import java.util.HashSet;

// Time Complexity: O(n) where n is the length of the string s
// Space Complexity: O(min(n, m)) where n is the length of s and m is the size of the character set
public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;

        int l = 0, r = 0;

        while (r < s.length()) {
            char toAdd = s.charAt(r);

            if (set.contains(toAdd)) {
                while (s.charAt(l) != toAdd) {
                    set.remove(s.charAt(l));
                    l++;
                }
                l++; // here we are escaping it
            }
            set.add(toAdd);
            r++;

            maxLen = Math.max(maxLen, r - l);

        }

        return maxLen;
    }
}