'''
## Problem 791: Custom sort string.

## Author: Neha Doiphode
## Date:   08-16-2022

## Description:
    You are given two strings order and s.
    All the characters of order are unique and were sorted in some custom order previously.
    Permute the characters of s so that they match the order that order was sorted.
    More specifically, if a character x occurs before a character y in order,
    then x should occur before y in the permuted string.

    Return any permutation of s that satisfies this property.

## Examples:
    Example 1:
        Input: order = "cba", s = "abcd"
        Output: "cbad"
        Explanation:
            "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".
            Since "d" does not appear in order, it can be at any position in the returned string.
            "dcba", "cdba", "cbda" are also valid outputs.

    Example 2:
        Input: order = "cbafg", s = "abcd"
        Output: "cbad"

## Constraints:
    1 <= order.length <= 26
    1 <= s.length <= 200
    order and s consist of lowercase English letters.
    All the characters of order are unique.

## Time complexity: O(m + n), where m is length of the order and n is length of the string.

## Space complexity: O(n), to create auxiliary hashmap to store counts for all characters in the input string.

'''

from typing import List, Optional
from collections import Counter

def get_input():
    print("Enter the input order string: ", end = "")
    order = input()
    print("Enter the input string: ", end = "")
    string = input()
    return order, string

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        result = ""
        char_cnt = Counter(s)

        for key in order:
            if key in s:
                cnt = char_cnt[key]
                substring = key * cnt
                result += substring
                del char_cnt[key]

        for char, cnt in char_cnt.items():
            substring = char * cnt
            result += substring

        return result

# Driver code
solution = Solution()
order, string = get_input()
print(f"Input order string: {order}")
print(f"Input string: {string}")
print(f"Output custom sorted string: {solution.customSortString(order, string)}")
