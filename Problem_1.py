from typing import Counter


class Solution:
    def customSortString(self, order, s):
        smap = Counter(s)
        result = []
        for c in order:
            if c in smap:
                while smap[c] != 0:
                    smap[c] -= 1
                    result.append(c)
                else:
                    smap.pop(c)
        for k, v in smap.items():
            while v > 0:
                result.append(k)
                v -= 1

        return "".join(result)
