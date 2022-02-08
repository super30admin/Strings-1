# TC : O(M+N)
# SC :O(N)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        import collections
        m = dict()
        for ch in s:
            if ch not in m:
                m[ch] = 1
            else:
                m[ch] += 1
        
        #print(m)
        res = ""
        for ch in order:
                if ch in m:
                    res = res + ch*m[ch]
                    m[ch] = 0
        #print(res)
        #print(m)
        for ch in s:
            if m[ch] != 0:
                res = res + ch
        
        return res
        
        
        
