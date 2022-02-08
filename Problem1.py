# // Time Complexity : O(m + n) where m is the lenght of s and n is length of order.
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        res = ""
        d = dict()
        for i in s:
            if i in d:
                d[i] += 1
            else:
                d[i] = 1
        t = ""
        for i in order:
            if i in d:
                temp = i * d[i]
                res += temp
                d.pop(i)
            
        for i in s:
            if i in d:
                res += i
        return res
