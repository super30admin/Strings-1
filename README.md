# Strings-1

## Problem1 
Custom Sort String (https://leetcode.com/problems/custom-sort-string/)
# Time Complexity=O(n)
# Time Complexity=O(s)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        h={}
        result=""
        for i in s:
            if i not in h:
                h[i]=1
            else:
                h[i]+=1
        for i in order:
            if i in h and h[i]>0:
                result+=i*h[i]
                h[i]=0
        for i in h:
            if h[i]>0:
                result+=i*h[i]
                h[i]=0
        return result
        



## Problem2 

Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)
# Time Complexity=O(n)
# Time Complexity=O(n)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        h={}
        sl,f=0,0
        m=0
        while f<len(s):
            if s[f] not in h:
                h[s[f]]=f
            elif s[f] in h:
                sl=max(sl,h[s[f]]+1)
                h[s[f]]=f
            m=max(m,f-sl+1)
            f+=1
        return m
        