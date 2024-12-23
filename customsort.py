class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hmap = {}
        n = len(s)
        for i in range(n):
            if s[i] not in hmap:
                hmap[s[i]] = 1
            else:
                hmap[s[i]] += 1
        res = ""
        for ch in order:
            if ch in hmap:
                while(hmap[ch] > 0):
                    res = res + ch
                    hmap[ch] -= 1
        for ch in hmap:
            if hmap[ch]>0:
                while(hmap[ch] > 0):
                    res = res + ch
                    hmap[ch] -= 1
        return res

