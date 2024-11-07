class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        char_map = {}
        max_length = 0
        slow = 0

        for i, c in enumerate(s):
            if c in char_map:
                slow = max(slow, char_map[c] + 1)

            char_map[c] = i
            max_length = max(max_length, i - slow + 1)

        return max_length

    # time complexity is O(n)
    # space complexity is O(26)
