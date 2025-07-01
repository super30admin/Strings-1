# Time complexity - o(n)
# Space compleity - o(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        if s =='':
            return 0

        if s == ' ':
            return 1
        
        hashTb = {}

        l,r = 0,0
        maximum = 0

        while r<len(s):
            if s[r] in hashTb and hashTb[s[r]] >= l:
                l = hashTb[s[r]] + 1
            hashTb[s[r]] = r
            maximum = max(r - l + 1, maximum)
            r += 1
            
        return maximum