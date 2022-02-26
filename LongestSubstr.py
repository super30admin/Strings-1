"""
Given a string s, find the length of the longest substring without repeating characters.

"""

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        # base
        if not s or len(s) == 0:
            return 0
    
        # logic
       
        slow = 0
        max1 = 0
        map1 = {}
        
        for i in range(len(s)):
            c = s[i]
            if c in map1:
                slow = max(slow, map1[c])
                
            map1[c] = i+1
            max1 = max(max1, i - slow + 1)
            
        return max1
        