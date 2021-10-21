class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        #TC O(n)
        #SC O(1)
        if s is None or len(s) == 0:
            return 0
        maps = {}
        slw = 0
        maxs = float(-inf)
        for i in range(len(s)):
            if s[i]  in maps:
                pos = maps[s[i]]
                slw = max(pos, slw)
            maps[s[i]] = i + 1
            maxs = max(maxs, i - slw + 1)
        return maxs
        
        
