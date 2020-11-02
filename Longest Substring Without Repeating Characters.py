# Time complexity : O(n). Index j will iterate n times.
# Space complexity (HashMap) : O(min(m,n)). Same as the previous approach.
# Space complexity (Table): O(m). m is the size of the charset.
# Yes, It ran on Leetcode.
# Problems: Was not able to think of left<=Hash[ch] in the code.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        left = 0
        Max = 0
        Hash = {}
        
        for right,ch in enumerate(s):
            if ch in Hash and left<=Hash[ch]:
                left = Hash[ch]+1
            else:
                Max = max(Max,right-left+1)
            Hash[ch] = right
            
        return Max