# T: O(m+n) S: O(1)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        freqMap = {}

        for i in s:
            if i in freqMap:
                freqMap[i] = freqMap[i] + 1
            else:
                freqMap[i] = 1
        res = []
        for i in order:
            if i in freqMap:
                for x in range(0, freqMap[i]):
                    res.append(i)
                del freqMap[i]

        for i in freqMap:
            for x in range(0, freqMap[i]):
                res.append(i)

        return "".join(res)
