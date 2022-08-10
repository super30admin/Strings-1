class Solution:
    #Time Complexity: O(N)
    #space Complexity: O(1)
    def lengthOfLongestSubstring(self, s: str) -> int:
        l, r = 0, 0
        seen = {}
        max_len = 0
        while r < len(s):
            char = s[r]
            if char in seen:
                l = max(seen[char], l)

            seen[char] = r + 1
            max_len = max(r - l + 1, max_len)
            r += 1
        return max_len


