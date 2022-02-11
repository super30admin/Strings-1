'''
TC: O(n)
SC: O(1)
'''
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        
        l, r = 0, 0
        hmap = dict()
        ll = 0
        
        while r < len(s):
            if s[r] in hmap:        
                l = max(l, hmap[s[r]])
        
            hmap[s[r]] = r + 1
            ll = max(ll, r - l + 1)
            r += 1
        
        
        return ll
        