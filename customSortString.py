class Solution:
    def customSortString(self, order: str, str: str) -> str:
        dataStore = dict()
        result = ""
        if not order:
            return None
        
        for i in str:
            
            if i not in dataStore:
                dataStore[i] = 0
            
            dataStore[i]+=1
        
        for j in order:
            if j in dataStore:
                count = dataStore[j]
                while count:
                    result += j
                    count-=1
                del dataStore[j]
            
        for k in dataStore:
            count = dataStore[k]
            while count:
                result += k
                count -= 1
        
        
        return result
    
#      Time complexity is O(m+n)
                    
        
