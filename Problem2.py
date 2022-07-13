'''
Time Complexity: O(n) where n is the length of the string
Space Complaxity: O(1)
Run on Leetcode: YES
'''
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) < 2:
            return len(s)
        result = 0
        hMap = {}
        slow = 0
        for fast in range(len(s)):
            if s[fast] in hMap:
                slow = max(slow, hMap[s[fast]])
            result = max(result, fast - slow + 1)
            hMap[s[fast]] = fast + 1
        return result