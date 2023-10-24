# Time Complexity: O(n) where n is the length of the string
#  Space Complexity: O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        d = dict()
        for i in s:
            if i not in d:
                d[i] = 0
            d[i] += 1
        res = ""
        for i in order:
            if i in d:
                res = res + i*d[i]
                d.pop(i)
        for key,val in d.items():
            res = res + key*val
        return res
