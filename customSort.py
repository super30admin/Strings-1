"""
hMap solution
TC = O(m+n)
SC = O(1) ==> O(1) since only 26 lowercase characters
"""

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        if order is None or len(order) == 0 or s is None or len(s) == 0: return ""

        hMap = defaultdict(int)
        rtnData = ""

        for i in range(len(s)):
            hMap[s[i]] += 1

        for i in range(len(order)):
            c = order[i]
            if c in hMap:
                count = hMap[c]
                del hMap[c]
                while count > 0:
                    rtnData += c
                    count -= 1

        # add remaining characters from hMap
        for key in hMap:
            c = key
            count = hMap[c]
            while count > 0:
                rtnData += c
                count -= 1

        return rtnData