# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# move slow pointer from current to previous occurence of the character
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) < 2:
            return len(s)
        i,j = 0,0
        maxi = 0
        prev = {}
        prev[s[i]] = 0
        while j < len(s):
            if s[j] in prev:
                i = max(i,prev[s[j]])
            
            maxi = max(maxi,j - i + 1)
            prev[s[j]]  = j + 1
            j += 1
        
        return maxi