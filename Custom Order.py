# Time complexity : O(len(order) + len(s))
# Space complexity : O(len(s)), to maintain a dictionary

# The code ran on Leetcode

# Maintain frequency of all elements in s in a dictionary. Iterate over order string and concatenate elements from the input string in the required order. At the end, just concatenate the remaining portion of the input string.

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        d = {}
        for i in range(len(s)):
            if s[i] in d:
                d[s[i]] += 1
            else:
                d[s[i]] = 1
        res = ''

        for i in range(len(order)):
            if order[i] in d:
                res += order[i]*d[order[i]]
                d[order[i]] = 0
        for k in d.keys():
            if d[k] > 0:
                res += k*d[k]
        return res
            