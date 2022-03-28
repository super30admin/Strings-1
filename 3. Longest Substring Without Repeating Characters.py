// Time Complexity : O(n) 
 // Space Complexity : O(1) 
 // Did this code successfully run on Leetcode : Yes
 // Any problem you faced while coding this : No 

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maps ={}
        slow = 0
        maxs  = 0
        for i in range(len(s)):
            if s[i] in maps.keys():
                slow = max(slow,maps[s[i]]) // "abba" for this the slow pointer will back to its initial point when its called
                # slow = max(slow,) 
            maxs = max(maxs,i-slow+1)
            maps[s[i]] = i+1
        return maxs
            
            
            
        