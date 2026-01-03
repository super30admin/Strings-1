// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.Arrays;

// Approach: Sliding window with slow pointer and an array
// TC: O(N); N = s.length()
// SC: 256 ASCII character ~= O(256) ~= O(1) space for the array
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lengthOfLongestSubstring = 0;
        int slowPointer = 0;
        int[] seenCharsAtIndices = new int[256];
        // Fill -1 values in seenCharsAtIndices array
        Arrays.fill(seenCharsAtIndices, -1);
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (slowPointer <= seenCharsAtIndices[ch]) {
                // calculate max length
                lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, i - slowPointer);
                // move slowPointer
                slowPointer = seenCharsAtIndices[ch] + 1;
            }
            // add character index to seen array
            seenCharsAtIndices[ch] = i;
        }
        // calculate max length for the last substring
        lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, s.length() - slowPointer);
        return lengthOfLongestSubstring;
    }
}