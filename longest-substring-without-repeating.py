"""
Runtime Complexity: O(n) - we traverse the whole string of size n
Space Complexity: O(n) - where 'n' is the length of string
Yes, the code worked on leetcode.
Issues while coding-No
"""

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s)==0:
            return 0
        slow = 0
        maxval = 0
        h_map = {}
        
        for i in range(slow,len(s)):
            char = s[i]
            if char in h_map:
                slow = max(slow,h_map[char])
            h_map[char]=i+1
            maxval =  max(maxval,i-slow+1)
            
        return maxval
        