# Time complexity - o(n)
# Space compleity - o(1)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        
        hashCnt = {}

        for c in s:
            if c not in hashCnt:
                hashCnt[c] = 0
            hashCnt[c] += 1

        res = ''

        for o in order:
            if o in hashCnt:
                cnt = hashCnt[o]
                for _ in range(cnt):
                    res+=o
                del hashCnt[o]

        if len(hashCnt)>0:
            for key in hashCnt:
                cnt = hashCnt[key]
                for _ in range(cnt):
                    res+=key
        return res

        