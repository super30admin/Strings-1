# TC: O(n)
# SC: O(1) auxiliary
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hmap={}
        res=""
        for i in s:
            if i not in hmap:
                hmap[i]=0
            
            hmap[i]+=1
        
        for i in order:
            if i in hmap:
                res+=i*hmap[i]
                del hmap[i]
        
        for i,j in hmap.items():
            res+=j*i
        
        return res
