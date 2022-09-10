#  3. Longest Substring Without Repeating Characters
'''
Leetcode all test cases passed: Yes
class Solution:
    def lengthOfLongestSubstring(self, a):
    n is length of a
      Time Complexity: O(n)
      Space Complexity: O(1)
'''
from collections import deque
class Solution:
    def lengthOfLongestSubstring(self, a):
        s = deque()
        res = 0
        for i in a:
            if i not in s:
                s.append(i)
            else:
                res = max(res , len(s))
                while i in s:
                    s.popleft()
                s.append(i)
        res = max(res , len(s))
        return res
