class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hmap = {}
        res = []

        # Count characters in s
        for c in s:
            if c not in hmap:
                hmap[c] = 0
            hmap[c]+=1

        # Add characters in the order specified by 'order'
        for c in order:
            if c in hmap:
                res.extend([c]*hmap[c])
                del hmap[c]

        # Add remaining characters not in 'order'
        for c in hmap:
            res.extend([c]*hmap[c])
        return "".join(res)
        