
"""
3. Longest Substring Without Repeating Characters
Medium
"""
import collections
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
Given a string s, find the length of the longest substring without repeating characters.
 
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 
Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.


"""

class Solution:
    """
    Accepted
    Time Complexity: O(n)
    Space Complexity: O(n) || O(min(n,m)) # worst case all characters are unique
    
    Approach: Sliding Window
        The intuition is to keep track of the last seen index of each character in the string. 
        If the character is already seen, then we move the window to the last seen index of the character + 1. 
        We also keep track of the length of the window and return the maximum length.
    """
    def lengthOfLongestSubstring(self, s: str) -> int:
        dic = {}
        i, j, size = 0, 0, len(s)
        res = 0
        while j < size:
            if s[j] not in dic:
                dic[s[j]] = j
                res = max(res, j-i+1)
                j += 1
            else:
                newI = dic[s[j]]
                while i <= newI: #move the window one more than the s[j] was last seen
                    if s[i] in dic:
                        del dic[s[i]] # keep deleting from the dic
                    i += 1 
                dic[s[j]] = j # the previous element which matches to s[j] is deleted, add the new entry
                j += 1
        return res
    
    """
    Not Accepted: TLE
    Time Complexity: O(n^3) # nested for loops
    Space Complexity: O(min(n,m)) # set
    
    Approach: Brute Force
    """
    def lengthOfLongestSubstring(self, s: str) -> int:
        def check(start, end):
            chars = set()
            for i in range(start, end + 1):
                c = s[i]
                if c in chars:
                    return False
                chars.add(c)
            return True

        n = len(s)

        res = 0
        for i in range(n):
            for j in range(i, n):
                if check(i, j):
                    res = max(res, j - i + 1)
        return res
LeetCode(PROBLEM, Solution).check()
