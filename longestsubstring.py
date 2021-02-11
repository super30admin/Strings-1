# -*- coding: utf-8 -*-
"""
TC:O(N) where N is the length of string s
SC: O(N) where  N is the length of string s maintain a set of N size
"""

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charSet = set()
        res, l = 0, 0
        
        for r in range(len(s)):
            while s[r] in charSet:
                charSet.remove(s[l])
                l += 1
            charSet.add(s[r])
            res = max(res, r - l + 1)
        return res
        