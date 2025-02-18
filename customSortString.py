class Solution:
    # Hashmap 
    # TC : O(m+n)
    # SC : O(1)
    def customSortString(self, order: str, s: str) -> str:
        if order is None or len(order) == 0:
            return s
        hmap = defaultdict(int)
        res = ""
        for ch in s:
            hmap[ch] += 1
        for i in range(len(order)):
            c = order[i]
            if c in hmap.keys():
                times = hmap[c]
                res += (c*times)
                hmap.pop(c)
        for key in hmap.keys():
            times = hmap[key]
            res += (key*times)
        return res
