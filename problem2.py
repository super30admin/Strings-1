#time O(n), O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        h={}
        m=0
        l=0
    #Sliding window     
        for i in range(len(s)):
            if s[i] in h:
                l=max(l,h[s[i]]+1)           
            h[s[i]]=i
            m=max(m,i-l+1)       
        return m
