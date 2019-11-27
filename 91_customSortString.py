'''
Accepted on leetcode(791)
time - O(N), space - O(1)
'''


class Solution:
    def customSortString(self, S: str, T: str) -> str:
        # edge case
        if S is None or T is None or len(S) == 0 or len(T) == 0:
            return T

        # Declare variables
        map = {}
        result = ""

        # Store characters of T into map
        for c in T:
            if c not in map:
                map[c] = 1
            else:
                map[c] += 1

        # iterate through string S and find all the matching characters in T and add to result.
        for c in S:
            if c in map:
                for i in range(map[c]):
                    result += c
                map.pop(c)

        # add the reamining characyters in hashmap to final result array.
        for c in map.keys():
            for i in range(map[c]):
                result += c

        return result
