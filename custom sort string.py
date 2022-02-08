# Time Complexity - O(m+n) - O(m+26)
# Space Complexity - O(1)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hmap = {}
        for i in range(len(s)):
            if s[i] not in hmap:
                hmap[s[i]]=1
            else:
                hmap[s[i]]=hmap[s[i]]+1
        result = ''
        for i in range(len(order)):
            if order[i] in hmap:
                for j in range(hmap[order[i]]):
                    result = result+order[i]
                del hmap[order[i]]
        for i in hmap:
            for j in range(hmap[i]):
                result = result+i
        return result
