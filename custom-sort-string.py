"""

You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.

Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.

 
Example 1:

Input: order = "cba", s = "abcd"
Output: "cbad"

Example 2:

Input: order = "bcafg", s = "abcd"
Output: "bcad"


Constraints:

1 <= order.length <= 26
1 <= s.length <= 200
order and s consist of lowercase English letters.
All the characters of order are unique.


Time Complexity: O(n + m), where n is the length of 's' and m is the length of 'order'.
Space Complexity: O(1), as we store character frequencies in a dictionary.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""


# Approach:
# 1. Count the frequency of each character in 's' using a dictionary.
# 2. Construct the result by appending characters in the order specified by 'order', followed by the remaining characters.
# 3. This ensures characters appear in the desired order while maintaining their original frequency.


class Solution:
    def customSortString(self, order: str, s: str) -> str:

        freq = {}

        res = ""

        for ch in s:
            freq[ch] = freq.get(ch, 0) + 1

        for ch in order:
            if ch in freq:
                res += (ch * freq[ch])
                del freq[ch]

        for i, v in freq.items():
            res += (i * v)
        
        return res

