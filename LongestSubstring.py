# Time Complexity o(N)
# Space Complexity o(n)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        max_ = 0
        
        slow = 0 
        
        hmap = {}
        
        for a in range(0,len(s)):
            
            if s[a] in hmap:
                slow = max(slow,hmap[s[a]])
            
            hmap[s[a]] = a+1
            max_ = max(max_, a - slow +1)
            
        return max_
                