#Time Complexity: O(n)
#Space Complexity: O(1)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        d = {}
        res = ""
        for i in s:
            d[i] = 1+d.get(i,0)
        for i in order:
            if i in d:
                res+=(d[i]*i)
                del d[i]
        for i in d:
            res+=(d[i]*i)
        return res
