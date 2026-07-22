/**
 * Time Complexity:  O(n) — each character is processed once.
 * Space Complexity: O(1), since the character map is bounded by ASCII (at most 128 unique characters).
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indices = new HashMap<>();
        int startIndex = -1;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (indices.containsKey(s.charAt(i)) && indices.get(s.charAt(i)) > startIndex) {
                startIndex = indices.get(s.charAt(i));
            }
            indices.put(s.charAt(i), i);
            result = Math.max(result, i - startIndex);

        }

        return result;

    }
}