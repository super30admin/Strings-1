"""

Given a string s, find the length of the longest substring without repeating characters.


Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1

Example 3:

Input: s = "pwwkew"
Output: 3

 
Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.


Time Complexity: O(n), as each character is processed at most twice (once added and once removed).
Space Complexity: O(min(n, m)), where `n` is the length of the string and `m` is the character set size (bounded by 26 for lowercase English letters).

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach: 
# used a sliding window with two pointers (`l` and `r`) to track the longest substring without repeating characters.  
# We maintain a set to store unique characters and shrink the window from the left when a duplicate is found.  
# The result is updated dynamically as traverse the string, ensuring an optimal O(n) solution.  


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        charSet = set()
        res = 0
        l = 0

        for r in range(len(s)):
            while s[r] in charSet:
                charSet.remove(s[l])
                l += 1

            charSet.add(s[r])
            res = max(res, r-l+1)

        return res  

