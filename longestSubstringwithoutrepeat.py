# TC: O(N) - smaller array len
# SC: O(1) -char arr(26)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s)==0:
            return 0
        if len(set(s))==1:
            return 1
        
        sub =set()
        l=0
        ans = 0
        
        for i in range(len(s)):
            while s[i] in sub:
                sub.remove(s[l])
                l+=1
            sub.add(s[i])
            ans = max(ans,i-l+1)
            
        return ans


                
                
  