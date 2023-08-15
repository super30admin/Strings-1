#Time Complexity :O(n)
#Space Complexity :O(1) 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        Smap={}
        maxLen=0
        slow=0
        for i in range(len(s)):
            if s[i] in Smap.keys():
                slow=max(slow,Smap[s[i]]+1)
                del(Smap[s[i]])
            maxLen=max(maxLen,i-slow+1)
            Smap[s[i]]=i 
        return maxLen

        