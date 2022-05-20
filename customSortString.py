# Time complexity -> O(n+m)
# Space complexity -> O(1)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        res = ''
        if not order:
            return res 
        hashMap = {}
        
        for i in s:
            hashMap[i] = hashMap.get(i,0)+1
            
        for i in order:
            if i in hashMap:
                count = hashMap[i]
                res += i*count
                
                del hashMap[i]
                
        for key,val in hashMap.items():
            res += key*val
            
        return res