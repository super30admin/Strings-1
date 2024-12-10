# TC: O(m+n)
# SC: O(n)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        map = {}
        for ch in s:
            if ch not in map:
                map[ch] = 1
            else:
                map[ch] += 1
        
        res = ""
        for c in order:
            if c in map:
                for i in range(map[c]):
                    res += c
                del map[c]
        
        if len(map.keys()) == 0:
            return res
        else:
            for key in map.keys():
                for i in range(map[key]):
                    res += key
        return res
