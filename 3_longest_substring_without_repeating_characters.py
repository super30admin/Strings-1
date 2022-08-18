'''
## Problem 3: Longest substring without repeating characters

## Author: Neha Doiphode
## Date:   08-16-2022

## Description:
    Given a string s, find the length of the longest substring without repeating characters.

## Examples:
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

    Example 4:
        Input: s = "abba"
        Output: 2
        Explanation: The answer is "ba", with the length of 2.

    Example 5:
        Input: s = "dvdf"
        Output: 3
        Explanation: The answer is "vdf", with the length of 3.

## Constraints:
    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.


## Time complexity: O(n), where n is length of the string.

## Space complexity: O(n), as we create auxiliary hashmap to track characters that are already encountered.

'''

from typing import List, Optional

def get_input():
    print("Enter the input string: ", end = "")
    string = input()
    print()
    return string

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start = 0
        max_length = 0
        hashmap = {}

        for end in range(len(s)):
            if s[end] in hashmap:
                start = max(start, hashmap[s[end]]) # in case index of repeating character is smaller than current start index,
                                                    # we don't want to move the start index backwards.
            hashmap[s[end]] = end + 1 # since we want to place start to next character after repeatition
            max_length = max(max_length, end - start + 1)
        return max_length


# Driver code
solution = Solution()
string = get_input()
print(f"Input string: {string}")
print(f"Longest substring without repeating characters is of length: {solution.lengthOfLongestSubstring(string)}")
