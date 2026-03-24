# https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

# Hashmap implementation
# TC: O(n)
# SC: O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0
        slow = 0
        hm = {}

        for i in range(len(s)):
            if s[i] in hm:
                slow = max(hm[s[i]] + 1, slow)
            hm[s[i]] = i
            res = max(res, i - slow + 1)

        return res