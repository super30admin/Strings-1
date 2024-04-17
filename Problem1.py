# T.C. : O(n)
# S.C. : O(1)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hmap = {}
        result = ""
        n = len(s)
        
        for char in s:
            hmap[char] = hmap.get(char, 0) + 1
        for char in order:
            if char in hmap:
                result += char * hmap[char]
                del hmap[char]
        
        for char, count in hmap.items():
            result += char * count
        return result
