"""" 
Time Complexity : O(n)
Space Complexity :O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :
"""

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        slow = 0
        maximum = 0
        d = {}
        for i in range(len(s)):
            if s[i] in d:
                slow = max(slow, d[s[i]])
            d[s[i]] = i + 1
            maximum = max(maximum, i - slow + 1)
        return maximum
