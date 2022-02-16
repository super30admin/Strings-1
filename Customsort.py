# Time Complexity o(n+m)
# Space Complexity : o(m)

class Solution:
    def __init__(self):
        
        self.hmap = {}
    
    def customSortString(self, order: str, s: str) -> str:
        
        
        hmap = {}
        
        for a in s:
            
            if a in hmap:
                hmap[a] +=1
            else:
                hmap[a] = 1
        
        print(hmap)
        result =""
        for x in order:
            if x in hmap:
                while(hmap[x]>0):
                    result += x
                    hmap[x]-=1
                del hmap[x]

        if len(hmap) > 0 :
            
            for j in hmap.keys():
                
                while hmap[j] > 0:
                    result += j
                    hmap[j] -=1
              
        return result  
        
            
                
       

        
            
            
            
            
            
            
        
            
            
            
        
        
        