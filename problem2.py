'''
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char = {}
        res = 0
        start = 0
        for i in range(len(s)):
            if s[i] in char:
                start = max(start, char[s[i]] + 1)
            char[s[i]] = i
            res = max(res, i - start + 1)
        return res