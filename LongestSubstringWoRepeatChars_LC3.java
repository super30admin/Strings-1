// Time Complexity : O(n) where n = s.length() is the length of the string,
// Space Complexity : O(min(n, m))  m is the size of the character se
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO

class LongestSubstringWoRepeatChars_LC3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int st = 0, len = 0;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If duplicate found, shrink window from left
            while (set.contains(ch)) {
                set.remove(s.charAt(st));
                st++;
            }

            // Add current character and update max length
            set.add(ch);
            len = Math.max(len, i - st + 1);
        }
        return len;
    }
}