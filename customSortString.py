#O - min(m.n) solution
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        
        d = {}
        for c in s:
            if c not in d:
                d[c] = 1
            else:
                d[c] += 1

        ans = ''
        for c in order:
            for _ in range(d.get(c,0)):
                ans+= c
            d[c] = 0
        for i in range(26):
            for j in range(d.get(chr(i + 97),0)):
                ans += chr(i + 97)
        return ans
        