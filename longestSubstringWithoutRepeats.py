# TC: O(n)
# SC: O(min(m,n)), m is size of character set ; n is size of string 
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hmap={}
        l=r=0
        mlength=0
        while r<len(s):
            if s[r] not in hmap:
                hmap[s[r]]=0
            hmap[s[r]]+=1
            while hmap[s[r]]>1:
                hmap[s[l]]-=1
                l+=1
            mlength=max(mlength, r-l+1)
            r+=1
        
        return mlength

            