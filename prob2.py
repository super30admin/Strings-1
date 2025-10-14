# Longest Substring Without Repeating Characters
# ------------------------------------------------
# Approach: Sliding Window
# Time Complexity: O(n), where n is the length of the string
# Space Complexity: O(min(n, m)), where m is the charset size (effectively constant for fixed character sets)
#
# Explanation:
# - We use a sliding window defined by two pointers: 'slow' (start) and the current index 'i' (end).

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        freq_map = {}  # stores character -> latest index
        res = 0  # longest substring length so far
        slow = 0  # start pointer of the current window

        for i, ch in enumerate(s):
            # If character was seen before, move 'slow' just past its last occurrence
            if ch in freq_map:
                slow = max(slow, freq_map[ch] + 1)

            # Update the longest length found so far
            res = max(res, i - slow + 1)

            # Store/update the latest index for this character
            freq_map[ch] = i

        return res
