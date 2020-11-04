# Time Complexity : O(n)
# Space Complexity : O(m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
# Your code here along with comments explaining your approach
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        sub = {}
        start = length = maxLength = 0
        for i,c in enumerate(s):
            if c in sub and sub[c] >= start: # If after start only then considered as repeating character
                start = sub[c] + 1
                length = i - sub[c]
                sub[c] = i
            else:
                sub[c] = i
                length += 1
                maxLength = max(length, maxLength)
        return maxLength 
