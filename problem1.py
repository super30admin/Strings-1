# Problem 1

# https://leetcode.com/problems/custom-sort-string/
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        map = {}
        for i in s:
            if i in map:
                map[i]+=1
            else:
                map[i]=1
        final_str = []
        for ch in order:
            if ch in map:
                count = map[ch]
                for _ in range(count):
                    final_str.append(ch)
                del map[ch]


        for k,val in map.items():
            for _ in range(val):
                final_str.append(k)
        return ''.join(final_str)
        