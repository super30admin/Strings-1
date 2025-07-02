"""
Approach: get a count of the s string annf add teh elements of s in the order of order by looping over it and
at the end add the elements that are not in the order (order for these elements don't matter)
t.c. => O(s + o)
s.c. => O(1)
"""
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        lenS = len(s)
        sCount = [0 for i in range(26)]

        for i in range(lenS):
            idx = ord(s[i]) - ord('a')
            sCount[idx] += 1
        
        res = []
        
        for c in order:
            idx = ord(c) - ord('a')
            count = sCount[idx]
            for i in range(count):
                res.append(c)
                sCount[idx] -= 1

        for i in range(26):
            if sCount[i] == 0:
                continue
            count = sCount[i]

            for j in range(count):
                res.append((chr(ord('a') + i)))
        
        return "".join(res)
        
        

