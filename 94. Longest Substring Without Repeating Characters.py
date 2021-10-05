class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        d = {}
        slow = 0
        max_length = 0
        for i in range(len(s)):
            c = s[i]
            if c in d.keys():
                slow = max(slow, d.get(c))

            max_length = max(max_length, i - slow + 1)
            d[c] = i + 1
        return max_length
