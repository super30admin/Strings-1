# ---------- Solution : Hashmap of s string-----
''' Time Complexity : O(m + n) 
    Space Complexity : O(1) ; hashmap would have only 26 char
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashmap = {}
        res = []
        for c in s:
            hashmap[c] = hashmap.get(c,0) + 1
        for c in order:
            if c in hashmap:
                cnt = hashmap[c]
                for i in range(cnt):
                    res.append(c)
                hashmap.pop(c)

        for c in hashmap.keys():
            cnt = hashmap[c]
            for i in range(cnt):
                res.append(c)
        
        return "".join(res)


        
        