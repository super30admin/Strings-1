"""
TC: O(n)+O(m) n len of order, m len of string
SP: O(m) len of string
"""
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        freqMap = defaultdict(int)
        for c in s:
            freqMap[c]+=1
        res = ""
        for o in order:
            if o in freqMap:
                res+=o*freqMap[o]
                del freqMap[o]
        for k, v in freqMap.items():
            res+=k*v
        return res
