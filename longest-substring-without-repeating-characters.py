# ---------- Solution : Sliding window-----
''' Time Complexity : O(n) 
    Space Complexity : O(1) ; 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        sett = set()
        l = 0 
        maxlen = 0
        for r in range(len(s)):
            while s[r] in sett:
                sett.remove(s[l])
                l += 1

            sett.add(s[r])
            maxlen = max(maxlen, (r-l)+1)
        
        return maxlen