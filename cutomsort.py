"""

# Strings-1

## Problem1
Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input:
S = "cba"
T = "abcd"
Output: "cbad"
Explanation:
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.


Note:

S has length at most 26, and no character is repeated in S.
T has length at most 200.
S and T consist of lowercase letters only.

TIME - 0(M+N)
SPACE - O(N)

"""

from collections import Counter


class Solution:
    def customSortString(self, S: str, T: str) -> str:

        output = ''
        d = {}
        # create hashmap/dic of all chars of T
        for char in T:
            if char in d:
                d[char] += 1
            else:
                d[char] = 1

        # check in dic/map and add to output and remove that character form hashmap
        for char in S:
            if char in d:
                count = d[char]
                while count > 0:
                    output += char
                    count -= 1
                d.pop(char)

        # for remaininig elements
        for k, v in d.items():
            count = v
            char = k
            while count > 0:
                output += char
                count -= 1
        return output



