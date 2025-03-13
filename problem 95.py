# https://leetcode.com/problems/custom-sort-string/

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hm = {}
        for i in s:
            if i not in hm:
                hm[i] = 1
            else:
                hm[i] += 1
        
        res = ""
        for i in order:
            if i in hm:
                res += i * hm[i]
                '''
                while hm[i] > 0:
                    res += i
                    hm[i] -= 1
                '''
                hm.pop(i,None)
        
        for k,v in hm.items():
            res += k * v
        
        return res

# Time Complexity (TC): O(n + m + k)
# Space Complexity (SC): O(k)