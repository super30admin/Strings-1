# Time O(m+n) n :len of s, m: len of order
# Space O(26) for cmap + O(n) for generating res
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        cmap = defaultdict(int)
        for c in s:
            cmap[c] += 1
        res = []
        for c in order:
            if c in cmap:
                for i in range(cmap[c]): res.append(c)
                del cmap[c]
        for c in cmap:
            for i in range(cmap[c]): res.append(c)
        return "".join(res) 