from collections import defaultdict
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        
        sDict = defaultdict(int)

        for c in s:
            sDict[c] += 1

        res = ''

        for c in order:
            if c in sDict:
                res += c * sDict[c]
                sDict[c] = 0

        for c in sDict:
            if sDict[c] != 0:
                res += (c * sDict[c])

        return res
