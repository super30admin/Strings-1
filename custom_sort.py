#time complexity : o max(m,n) where m = length of order and n = length of s
#space complexit: o(1) since hashmap will consume space of max 26 letters

from collections import Counter
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        s_n=Counter(s)
        result = ""        
        for c in order:
            if c in s_n:
                cnt = s_n.get(c)
                while cnt !=0:
                    result=result+c  
                    cnt-=1
                del s_n[c]
        print(result)
        print(s_n) 
        
        # iterate through remaining keys in hashmap
        for t in s_n:
            print(t)
            cl=s_n.get(t)
            while cl!= 0:
                result=result+t
                cl-=1
            
            
        print(result)
        return result
