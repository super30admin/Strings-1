'''
time complexity: O(n)
n is len of s
space complexity: O(1)
'''
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        l = 0
        charSet = set()
        res = 0
        for r in range(len(s)):
            while s[r] in charSet:
                charSet.remove(s[l])
                l+=1
        
            charSet.add(s[r])
            res = max(res,r-l+1)
        return res
        