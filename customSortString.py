from collections import Counter


class Solution:
    def customSortString(self, order: str, s: str) -> str:
        dict = Counter(s)
        res = ""
        for i in range(len(order)):
            if order[i] in dict:
                res += order[i]*dict[order[i]]
                del dict[order[i]]
        
        for c in dict:
            res += c*dict[c]

        return res
#TC: O(n)
#SC: O(1)
