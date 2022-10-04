// Time complexity: O(n)

// Space complexity: O(n)

// Approach: Sliding window. This is an optimized version of the hashset. O(n) instead of O(2n)
// We take slow and fast pointers. We keep adding the character at the fast index to the map along with it's index plus 1 until we find a repeated char (already previously added in map). At that point, we move the slow pointer to the index of repeated character plus 1. So basically we are initally increasing the window to find the longest substring and then when we get a repeated character, we shrink the window by escaping the repeated character that we achieve by moving slow pointer to index plus 1 of repeated character. Our maximum window is the max length.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int longestLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int slow = 0;
        for (int fast = 1; fast < s.length(); fast++) {
           char c = s.charAt(fast);
           if (map.containsKey(c)) {
               slow = Math.max(slow, map.get(c) + 1);
           }
           longestLength = Math.max(longestLength, fast-slow+1);
           map.put(c, fast);
        }
        return longestLength;
    }
}