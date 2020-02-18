"""
Time Complexity : O(n) - where n is the len(s)
Space Complexity : O(m) - where m is the number of unique characters in string s
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s or len(s) == 0:
            return 0
        
        char_idx_map = {}
        slow = 0
        fast = 0
        max_len = 0
        
        while fast < len(s):
            if s[fast] not in char_idx_map:
                char_idx_map[s[fast]] = fast + 1
            else:
                slow = max(slow, char_idx_map[s[fast]])
                char_idx_map[s[fast]] = fast + 1
            
            max_len = max(max_len, (fast-slow) + 1)
            fast += 1
            
        return max_len