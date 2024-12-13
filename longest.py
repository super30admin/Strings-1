# The lengthOfLongestSubstring method finds the length of the longest substring without repeating characters.

# Use a sliding window with two pointers:
# - 'l' marks the start of the current substring, and 'r' expands the window.
# - If s[r] is in the character set, shrink the window by removing s[l] and incrementing 'l'.
# - Add s[r] to the set and update the maximum length.

# TC: O(n) - Each character is added and removed from the set at most once.
# SC: O(n) - Space for the character set.


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charSet = set()
        l = 0
        res = 0

        for r in range(len(s)):
            while s[r] in charSet:
                charSet.remove(s[l])
                l += 1
            charSet.add(s[r])
            res = max(res, r - l + 1)
        return res
