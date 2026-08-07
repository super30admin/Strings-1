class Solution {
    /*
     * Time Complexity: O(N) where N is the length of the string 's'
     * Space Complexity: O(min(M, N)) where M is the size of the character set
     * This solution uses a sliding window approach to find the length of the longest substring
     * without repeating characters. 
     * slow represents the starting index of the current window.
     * The HashMap stores the last index where each character was seen.
     * Traverse the string with pointer i: If the current character has already appeared within 
     * the current window, move slow to one position after its previous occurrence.
     */
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                slow = Math.max(slow, map.get(c) + 1);
            }

            map.put(c, i);
            max = Math.max(max, i - slow + 1);
        }

        return max;
    }
}