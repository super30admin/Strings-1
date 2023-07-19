# Time Complexity : O(N) for each operation.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to use sliding window and move the start slow pointer accordingly.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        v=set()
        mx=0
        sl=0
        for i in range(0,len(s)):
            if s[i] in v:
                while(s[sl]!=s[i]):
                    v.remove(s[sl])
                    sl+=1
                sl+=1
            else:
                v.add(s[i])
            
            mx=max(mx, i-sl+1)
        return mx