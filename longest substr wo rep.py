"""
## Problem2

Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


"""

##BRUTtforce
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:








# TIME - O(N) , SPACE-  O(N)  N IS LENGTH OF STRING

# whie loop optimal using sliding window and two pointers slow AND FAST AND DIC
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s == None or len(s) == 0:
            return 0
        dic = {}
        slow = 0
        fast = 0
        max_ = 0
        while fast < len(s):
            # repeating
            if s[fast] in dic:
                slow = max(slow, dic[s[fast]])

            dic[s[fast]] = fast + 1
            max_ = max(max_, fast - slow + 1)
            fast += 1
        return max_




    # FOR loop optimal using sliding window and two pointers slow AND FAST
    class Solution:
        def lengthOfLongestSubstring(self, s: str) -> int:
            if s == None or len(s) == 0:
                return 0
            dic = {}
            slow = 0
            fast = 0
            max_ = 0
            for i in range(len(s)):

                #IF WE FOUND repeating Char , move slow pointer to max(slow, dic[s[i]])
                if s[i] in dic:
                    slow = max(slow, dic[s[i]])

                dic[s[i]] = i+1
                max_ = max(max_, fast-slow+1)
                fast +=1
            return max_