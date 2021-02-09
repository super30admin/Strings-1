# TC: O(len(S) + len(T))
# SC: O(len(T))

class Solution:
    def heapSol(self, S, T):
        priority = dict(zip(S, range(len(S))))
        q = []            
        suffix = ""
        for c in T:
            if priority.get(c, False):
                heappush(q, (priority[c], c))
            else:
                suffix += c
        
        result = ""
        while q:
            c = heappop(q)
            result += c[1]
        
        return suffix+result
    
    
    def customSortString(self, S: str, T: str) -> str:
              
        
        counts = collections.Counter(T)
        result = ""
        for c in S:
            result += c*counts[c]
            del counts[c]
        
        for k in counts.keys():
            result += k*counts[k]
        
        return result