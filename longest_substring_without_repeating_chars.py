# Leetcode 3 https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charSet =set()
        res = 0
        # use sliding window technique
        left = 0
        for r in range(len(s)):
            while s[r] in charSet:
                charSet.remove(s[left])
                left += 1
            charSet.add(s[r])
            res = max(res, r-left+1)
            print(res)
        return res
    
    #TC: O(N)  SC:O(N)