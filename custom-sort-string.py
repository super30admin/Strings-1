'''
TC: O(m + n)
SC: O(m)

Intuition: Freq count of s and loop through order
'''
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hmap = dict()
        
        for c in s:
            hmap[c] = hmap.get(c, 0) + 1
        
        res = ""
        
        for o in order:
            if o not in hmap:
                continue
            res += o * hmap[o]
            hmap.pop(o)
            
        for c in hmap:
            res += c * hmap[c]
        
        return res
        
        