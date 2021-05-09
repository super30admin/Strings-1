from collections import Counter

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        if not S:
            return ""
                         
        counter = Counter(T)
        print (counter)
        result = ""
        for i in S:
            if i in counter:
                while counter[i] > 0:
                    result += i
                    counter[i] -=1                 
                del counter[i]
        #copy leftover from counter
        for key,value in counter.items():
            while value>0:
                result += key
                value -=1
        
        return result
                    
