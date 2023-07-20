// Time Complexity - 0(n) 
// Space Complexity - 0(m)

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (charMap.containsKey(currentChar)) {
                left = Math.max(left, charMap.get(currentChar) + 1);
            }
            charMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}