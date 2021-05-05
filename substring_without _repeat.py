class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s is None or len(s) == 0:
            return 0
        slow = 0
        res = 0
        char_map = {}
        for i in range(len(s)):
            c = s[i]
            if c in char_map:
                slow = max(slow, char_map[c])
            char_map[c] = i + 1
            res = max(res, i - slow + 1)
        return res
