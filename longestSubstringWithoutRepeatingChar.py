"""
Time complexity: O(N) where N is the length of the given string
Space complexity: O(1)
Compiled on leetcode?: Yes
Difficulties faced: Coming up with the edge cases for python (Line 9 - Line 12)
"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0 or s is None:
            return 0
        if len(s) == 1:
            return 1
        maxLengthSoFar = 0
        visitedCharacterWithIndex = {}
        fast = 0
        slow = 0
        while fast < len(s):
            if s[fast] in visitedCharacterWithIndex:
                stringLength = fast - slow
                maxLengthSoFar = max(maxLengthSoFar, stringLength)
                slow = max(slow, visitedCharacterWithIndex[s[fast]])
                visitedCharacterWithIndex[s[fast]] = fast + 1
            else:
                visitedCharacterWithIndex[s[fast]] = fast + 1
            fast += 1
        stringLength = fast - slow
        maxLengthSoFar = max(maxLengthSoFar, stringLength)    
        return maxLengthSoFar