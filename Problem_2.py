"""
Time Complexity - O(2n)
Space Complexity - O(n)

Works on Leetcode
"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charSet = set()
        l=0
        r=0
        maxLen = 0
        #use sliding window, if new character entering the window is present in set then reduce window size from left until we do not remove the earlier occurrance
        while r < len(s):
            if s[r] in charSet:
                while s[r] in charSet:
                    charSet.remove(s[l])
                    l+=1
            charSet.add(s[r])
            maxLen = max(maxLen, r - l+1)
            r+=1
        return maxLen
        