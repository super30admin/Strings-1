#Time Complexity O(m +n)
#Space Complexity O(m) nearly constant

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        data =dict()
        res = ""
        
        for x in order:
            data[x]=0
        
        for x in s:
            if x in data:
                data[x]+=1
        
        for x in order:
            for y in range(data[x]):
                res= res + x
                
                
        for x in s:
            if x not in data:
                res = res + x
        return res
            
