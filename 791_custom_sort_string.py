"""
Leetcode: https://leetcode.com/problems/custom-sort-string/

Approach:
1. Store the characters from T in hashmap with values as their occurence.
2. Iterate through each character in S i.e. custom sorted string and check if map contains the character (t contains that character). If it exists then add all the occurrences into output string at once (sorting means priority is same for all occurrences of one character)
3. Once all the characters from custom sorted string are appended, left over characters in map can be appended in any sequence

Time Complexity: O(m + n), where m and n is the length of S and T respectively.
Space Complexity: O(n) for hashmap
"""


class Solution:
    def customSortString(self, S: str, T: str) -> str:
        # define hashmap and output string
        t_map = {}
        output = ''

        # store chars from T in hashmap with values as count of occurence
        for c in T:
            if c in t_map:
                t_map[c] += 1
            else:
                t_map[c] = 1

        # add chars of S to output in the same order if it exists in hashmap
        for ch in S:
            if ch in t_map:
                count = t_map[ch]
                while count > 0:
                    output += ch
                    count -= 1
                del t_map[ch]

        # add leftover chars from hashmap to output
        for leftover in t_map:
            count = t_map[leftover]
            while count > 0:
                output += leftover
                count -= 1

        # output string
        return output
