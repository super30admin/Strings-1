## Problem1 
# Custom Sort String (https://leetcode.com/problems/custom-sort-string/)
# TC : O(max(len(order), len(s)))
# SC : O(1)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        d = defaultdict(int)
        res = ''
        for i in s:
            d[i] += 1
        for j in order:
            if j in d :
                while d[j]>0:
                    res += j
                    s = s.replace(j, "", 1)
                    d[j] -= 1
        return res+s
        # print(d, res, s)
                
        