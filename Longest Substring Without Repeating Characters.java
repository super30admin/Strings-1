class Solution {
    // TC: O(n), where n = s.length()
    // SC: O(1), since the character set is fixed (ASCII)
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128]; // ASCII
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map[c]++;
            while (map[c] > 1) {
                map[s.charAt(left)]--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
