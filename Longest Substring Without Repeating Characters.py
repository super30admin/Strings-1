# Time Complexity : O(n)
# Space Complexity : O(n) max 26
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        curmax = 0
        chidx = {}
        l = r = 0
        while l <= r and r < len(s):
            if s[r] in chidx:
                l = max(chidx[s[r]] + 1,l)
            chidx[s[r]] = r
            curmax = max(curmax,r-l+1)
            r += 1
            
        return curmax

            
        