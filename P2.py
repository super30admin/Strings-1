# TC : O(n)
# SC : O(1)    as Dict has only 26 keys
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s==None or len(s)==0:
            return 0
        res = 0
        start = 0
        d = {}
        for i in range(len(s)):
            curr = s[i]
            if curr in d:
                start = max(start, d[curr] )
                # print(start, s[i])
            d[curr] = i + 1
            res = max(res, i - start + 1)
        return res
                
            
            
        