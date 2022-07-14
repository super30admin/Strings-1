"""
TC/SC: O(n)/O(26)
"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) < 1:
            return len(s)
        i = 0
        start = 0
        longest = 0
        idxMap = {}
        while i < len(s):
            if s[i] in idxMap:
                start = max(start,idxMap[s[i]]+1)

            longest = max(longest, i - start + 1)
            idxMap[s[i]] = i
            i += 1
        
        return longest
