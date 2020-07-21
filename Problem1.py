class Solution:
    """
    
        Name : Shahreen Shahjahan Psyche
        Time : O(2N) [Where N is the size of string T]
        Space: O(1) [Cause the hashmap will be max of 26]
    
    
    """
    def customSortString(self, S: str, T: str) -> str:
        
        if not S:
            return T
        
        if not T:
            return ""
        
        
        records = {}
        res = ""
        
        for i in range(len(T)):
            
            if T[i] not in records.keys():
                records[T[i]] = 1
            else:
                records[T[i]] += 1
                
                
        for j in range(len(S)): 
            if S[j] in records.keys():
                ct = records[S[j]]
                for _ in range(ct):
                    res = res + S[j]
                del records[S[j]]
                    
                
        for i, j in records.items():
            ct = j
            for _ in range(ct):
                res = res + i
        
        return res
        
                
            
        
    
        
        
        
