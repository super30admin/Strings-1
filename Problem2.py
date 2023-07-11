'''
Problem: Longest Substring Without Repeating Characters
Time Complexity: O(n) where n characters in s
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        sliding window
        move slow only when it is increasing and not decreasing
        use hashmap wherein store character and index
'''

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        dicts ={}
        slow = 0
        result = 0

        for i in range(len(s)):
            if s[i] in dicts:
                slow = max(slow, dicts[s[i]]+1)
            dicts[s[i]] = i
        
            result = max(result, i - slow + 1)
        
        return result