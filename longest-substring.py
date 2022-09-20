# // Time Complexity : O(n) //We are iterating once over the string
# // Space Complexity : O(n) // we use dict to store 
# // Did this code successfully run on Leetcode : yes

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        fast=0
        slow=0
        res=0
        d=dict()
        while fast<len(s):
            if s[fast] in d:
                slow=max(slow,d[s[fast]])
            d[s[fast]]=fast+1
            res=max(res, fast-slow+1)
            fast+=1
        return res
                